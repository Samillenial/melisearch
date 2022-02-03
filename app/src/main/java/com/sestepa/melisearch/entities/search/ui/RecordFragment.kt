package com.sestepa.melisearch.entities.search.ui

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.sestepa.melisearch.R
import com.sestepa.melisearch.databinding.FragmentRecordBinding
import com.sestepa.melisearch.entities.search.domain.ProductData

private const val TAG = "RecordFragment"

class RecordFragment: Fragment(R.layout.fragment_record) {

	private lateinit var binding: FragmentRecordBinding

	private val viewModel: SearchViewModel by viewModels()

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)
		Log.i(TAG, "onViewCreated")

		binding = FragmentRecordBinding.bind(view)

		viewModel.getSearchRecord()

		viewModel.searchResult.observe(viewLifecycleOwner) {
			binding.progressBar.visibility = View.GONE
			Log.i(TAG, "Download query result")

			viewModel.searchResult.value!!.products.forEach { item ->
				Log.i(TAG, "ITEM: $item")
			}

			configRecyclerView()
		}

		viewModel.currentProduct.observe(viewLifecycleOwner) {
			viewModel.saveProductRecord()
		}
	}

	private fun configRecyclerView() {
		val manager = LinearLayoutManager(context)

		binding.resultRecycler.layoutManager = manager
		binding.resultRecycler.adapter = SearchAdapter(viewModel.searchResult.value!!) { product ->
			onItemSelected(product)
		}

		binding.resultRecycler.addItemDecoration(DividerItemDecoration(context, manager.orientation))
	}

	private fun onItemSelected(product: ProductData) {
		viewModel.currentProduct.value = product
	}
}
