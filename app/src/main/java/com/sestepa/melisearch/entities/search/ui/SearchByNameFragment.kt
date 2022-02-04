package com.sestepa.melisearch.entities.search.ui

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.sestepa.melisearch.R
import com.sestepa.melisearch.core.hideKeyboard
import com.sestepa.melisearch.core.onQuerySummit
import com.sestepa.melisearch.core.showToast
import com.sestepa.melisearch.databinding.FragmentSearchNameBinding
import com.sestepa.melisearch.entities.search.domain.ItemData

private const val TAG = "SearchByNameFragment"

class SearchByNameFragment: Fragment(R.layout.fragment_search_name) {

	private lateinit var binding: FragmentSearchNameBinding

	private val viewModel: SearchViewModel by viewModels()
	private val args: SearchByNameFragmentArgs by navArgs()

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)
		Log.i(TAG, "onViewCreated")

		binding = FragmentSearchNameBinding.bind(view)

		configSearchView()

		viewModel.searchResult.observe(viewLifecycleOwner) { result ->
			binding.progressBar.visibility = View.GONE

			if(result.isEmpty()) {
				Log.e(TAG, "Download ITEMS fail")

				requireContext().showToast(getString(R.string.try_again))
				requireActivity().onBackPressed()
			} else {
				Log.i(TAG, "Download ITEMS successful !!!")
				result.items.forEach { item -> Log.i(TAG, "ITEM: $item") }

				configRecyclerView()
			}
		}

		viewModel.currentItem.observe(viewLifecycleOwner) { item ->
			Log.i(TAG, "Try Save Item Record ${item.title}")
			viewModel.saveItemRecord()
		}
	}

	private fun configSearchView() {
		binding.searchView.setIconifiedByDefault(false)

		binding.searchView.onQuerySummit { text ->
			Log.i(TAG, "Text Query [$text]")

			if(text.isNotEmpty()) {
				viewModel.textQuery.value = text
				viewModel.getItemsByName(args.site.id)
			}

			context?.hideKeyboard(binding.searchView)
			binding.progressBar.visibility = View.VISIBLE
			true
		}
	}

	private fun configRecyclerView() {
		val manager = LinearLayoutManager(context)

		binding.resultRecycler.layoutManager = manager
		binding.resultRecycler.adapter = SearchAdapter(viewModel.searchResult.value!!) { item ->
			onItemSelected(item)
		}

		binding.resultRecycler.addItemDecoration(DividerItemDecoration(context, manager.orientation))
	}

	private fun onItemSelected(item: ItemData) {
		viewModel.currentItem.value = item
		requireContext().showToast(item.title)
		Navigation.findNavController(requireView()).navigate(SearchByNameFragmentDirections.actionSearchByNameFragmentToProductFragment(item.id))
	}
}

