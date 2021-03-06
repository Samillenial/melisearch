package com.sestepa.melisearch.entities.search.ui

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.sestepa.melisearch.R
import com.sestepa.melisearch.core.showToast
import com.sestepa.melisearch.databinding.FragmentRecordBinding
import com.sestepa.melisearch.entities.product.domain.ProductData
import dagger.hilt.android.AndroidEntryPoint

private const val TAG = "RecordFragment"

@AndroidEntryPoint
class RecordFragment: Fragment(R.layout.fragment_record) {

	private lateinit var binding: FragmentRecordBinding
	private val viewModel: SearchViewModel by viewModels()

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		Log.i(TAG, "onViewCreated")
		super.onViewCreated(view, savedInstanceState)

		binding = FragmentRecordBinding.bind(view)

		viewModel.getSearchRecord()
		viewModel.searchResult.observe(viewLifecycleOwner) { result ->

			binding.progressBar.visibility = View.GONE

			if(result.isEmpty()) {
				Log.e(TAG, "Fail ITEMS download")

				requireContext().showToast(getString(R.string.no_items))
				requireActivity().onBackPressed()
			} else {
				Log.i(TAG, "Download ITEMS successful!")
				result.items.forEach { item -> Log.i(TAG, "ITEM: $item") }

				configRecyclerView()
			}
		}

		viewModel.currentItem.observe(viewLifecycleOwner) { item ->
			Log.i(TAG, "Try Save Item Record ${item.title}")
			viewModel.saveItemRecord()
		}
	}

	private fun configRecyclerView() {
		val manager = LinearLayoutManager(context)

		binding.resultRecycler.layoutManager = manager

		viewModel.searchResult.value?.let { searchData ->
			SearchAdapter(searchData) { item ->
				onItemSelected(item)
			}
		}

		binding.resultRecycler.addItemDecoration(DividerItemDecoration(context, manager.orientation))
	}

	private fun onItemSelected(item: ProductData) {
		viewModel.currentItem.value = item
		requireContext().showToast(item.title)
		Navigation.findNavController(requireView()).navigate(RecordFragmentDirections.actionRecordFragmentToProductFragment(item.id))
	}
}
