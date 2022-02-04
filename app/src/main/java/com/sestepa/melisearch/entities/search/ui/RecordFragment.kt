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
import com.sestepa.melisearch.entities.search.domain.ItemData

private const val TAG = "RecordFragment"

class RecordFragment: Fragment(R.layout.fragment_record) {

	private lateinit var binding: FragmentRecordBinding
	private val viewModel: SearchViewModel by viewModels()

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)

		Log.i(TAG, "onViewCreated")
		binding = FragmentRecordBinding.bind(view)

		viewModel.getSearchRecord()
		viewModel.searchResult.observe(viewLifecycleOwner) { result ->

			binding.progressBar.visibility = View.GONE

			if(result.isEmpty()) {
				Log.e(TAG, "Fail ITEMS download")

				requireContext().showToast(getString(R.string.try_again))
				requireActivity().onBackPressed()
			} else {
				Log.i(TAG, "Download ITEMS successful !!!")
				result.items.forEach { item -> Log.i(TAG, "ITEM: $item") }

				configRecyclerView()
			}
		}

		viewModel.currentItem.observe(viewLifecycleOwner) { item ->
			Log.i( TAG, "Try Save Item Record ${item.title}")
			viewModel.saveItemRecord()
		}
	}

	private fun configRecyclerView()
	{
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
		Navigation.findNavController(requireView()).navigate(RecordFragmentDirections.actionRecordFragmentToProductFragment(item.id))
	}
}
