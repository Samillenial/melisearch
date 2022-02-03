package com.sestepa.melisearch.entities.search.ui

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.sestepa.melisearch.R
import com.sestepa.melisearch.core.showToast
import com.sestepa.melisearch.databinding.FragmentSearchCategoryBinding
import com.sestepa.melisearch.entities.search.domain.ProductData

private const val TAG = "SearchByCategoryFragment"

class SearchByCategoryFragment: Fragment(R.layout.fragment_search_category) {

	private lateinit var binding: FragmentSearchCategoryBinding

	private val viewModel: SearchViewModel by viewModels()
	private val args: SearchByCategoryFragmentArgs by navArgs()

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)
		Log.i(TAG, "onViewCreated")

		binding = FragmentSearchCategoryBinding.bind(view)
		binding.title.text = args.category.name

		viewModel.getItemsByCategory(args.site.id, args.category.id)

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
		requireContext().showToast(product.title)
	}
}

