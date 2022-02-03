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
import com.sestepa.melisearch.core.hideKeyboard
import com.sestepa.melisearch.core.onQuerySummit
import com.sestepa.melisearch.core.showToast
import com.sestepa.melisearch.databinding.FragmentSearchNameBinding
import com.sestepa.melisearch.entities.search.domain.ProductData

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

	private fun configSearchView() {
		binding.searchView.setIconifiedByDefault(false)

		binding.searchView.onQuerySummit { text ->
			Log.i(TAG, "Text Query [$text]")

			if(!text.isNullOrEmpty()) {
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

