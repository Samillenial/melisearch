package com.sestepa.melisearch.entities.product.ui

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
import com.sestepa.melisearch.databinding.FragmentProductSearchBinding
import com.sestepa.melisearch.entities.product.domain.ProductData


private const val TAG = "SearchFragment"

class ProductSearchFragment: Fragment(R.layout.fragment_product_search) {

	private lateinit var binding: FragmentProductSearchBinding

	private val args: ProductSearchFragmentArgs by navArgs()
	private val viewModel: ProductViewModel by viewModels()

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)
		Log.i(TAG, "onViewCreated")

		binding = FragmentProductSearchBinding.bind(view)

		binding.searchView.onQuerySummit{ text ->
			Log.i( TAG, "Text Query [$text]")

			if( !text.isNullOrEmpty()) {
				viewModel.textQuery.value = text
				viewModel.getProductQuery( args.site.id)
			}

			context?.hideKeyboard(binding.searchView)
			binding.progressBar.visibility = View.VISIBLE
			true
		}

		viewModel.productQueryResult.observe(viewLifecycleOwner) { list ->
			binding.progressBar.visibility = View.GONE
			Log.i(TAG, "Download query result")
			list.forEach { Log.i(TAG, "PRODUCT: $it") }
			initRecyclerView()
		}
	}

	private fun initRecyclerView() {
		val manager = LinearLayoutManager(context)

		binding.resultRecycler.layoutManager = manager
		binding.resultRecycler.adapter = ProductAdapter(viewModel.productQueryResult.value ?: listOf()) { product ->
			onItemSelected(product)
		}

		binding.resultRecycler.addItemDecoration(DividerItemDecoration(context, manager.orientation))
	}

	private fun onItemSelected(product: ProductData) {
		viewModel.currentProduct.value = product
	}
}
