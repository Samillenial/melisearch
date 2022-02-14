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
import com.sestepa.melisearch.core.isNull
import com.sestepa.melisearch.core.showToast
import com.sestepa.melisearch.databinding.FragmentSearchCategoryBinding
import com.sestepa.melisearch.entities.product.domain.ProductData
import dagger.hilt.android.AndroidEntryPoint

private const val TAG = "SearchByCategoryFragment"

@AndroidEntryPoint
class SearchByCategoryFragment: Fragment(R.layout.fragment_search_category) {

	private lateinit var binding: FragmentSearchCategoryBinding

	private val viewModel: SearchViewModel by viewModels()
	private val args: SearchByCategoryFragmentArgs by navArgs()

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)
		Log.i(TAG, "onViewCreated")

		binding = FragmentSearchCategoryBinding.bind(view)
		binding.title.text = args.category.name

		if(viewModel.searchResult.value.isNull())
			viewModel.getItemsByCategory(args.site.id, args.category.id)

		viewModel.searchResult.observe(viewLifecycleOwner) { result ->
			binding.progressBar.visibility = View.GONE

			if(result.isEmpty()) {
				Log.e(TAG, "Download CATEGORY fail")

				requireContext().showToast(getString(R.string.try_again))
				requireActivity().onBackPressed()
			} else {
				Log.i(TAG, "Download CATEGORY successful!")
				result.items.forEach { item -> Log.i(TAG, "ITEM: $item") }

				configRecyclerView()
			}
		}

		viewModel.currentItem.observe(viewLifecycleOwner) { item ->
			Log.i(TAG, "Try Save Item Record $item.title")
			viewModel.saveItemRecord()
		}
	}

	private fun configRecyclerView() {
		val manager = LinearLayoutManager(context)

		binding.resultRecycler.layoutManager = manager

		binding.resultRecycler.adapter = viewModel.searchResult.value?.let { searchData ->
			SearchAdapter(searchData) { item ->
				onItemSelected(item)
			}
		}

		binding.resultRecycler.addItemDecoration(DividerItemDecoration(context, manager.orientation))
	}

	private fun onItemSelected(item: ProductData) {
		viewModel.currentItem.value = item
		requireContext().showToast(item.title)
		Navigation.findNavController(requireView()).navigate(SearchByCategoryFragmentDirections.actionSearchByCategoryFragmentToProductFragment(item.id))
	}
}

