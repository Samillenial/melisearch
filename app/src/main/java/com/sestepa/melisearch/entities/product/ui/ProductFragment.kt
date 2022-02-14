package com.sestepa.melisearch.entities.product.ui

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sestepa.melisearch.R
import com.sestepa.melisearch.core.PREFIX_TAG
import com.sestepa.melisearch.core.showToast
import com.sestepa.melisearch.databinding.FragmentProductBinding
import com.sestepa.melisearch.entities.product.domain.ProductData
import com.sestepa.melisearch.entities.search.ui.SearchAdapter
import dagger.hilt.android.AndroidEntryPoint

private const val TAG = PREFIX_TAG + "ProductFragment"

@AndroidEntryPoint
class ProductFragment: Fragment(R.layout.fragment_product) {

	private lateinit var binding: FragmentProductBinding

	private val viewModel: ProductViewModel by viewModels()
	private val args: ProductFragmentArgs by navArgs()

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		Log.i(TAG, "onViewCreated")
		super.onViewCreated(view, savedInstanceState)

		binding = FragmentProductBinding.bind(view)

		viewModel.getProductDetail(args.productId)
		viewModel.productDetail.observe(viewLifecycleOwner) { product ->

			binding.progressBar.visibility = View.GONE

			if(product.isEmpty()) {
				Log.e(TAG, "Fail PRODUCT download")

				requireContext().showToast(getString(R.string.try_again))
				requireActivity().onBackPressed()
			} else {
				Log.i(TAG, "Download PRODUCT successful!")
				Log.i(TAG, product.toString())

				fillView(product)
			}
		}
	}

	private fun fillView(product: ProductData) {
		binding.name.text = product.title
		binding.ratingBar.rating = product.rate

		binding.condition.text = product.condition
		binding.price.text = product.price

		configImageRecycler(product.images)
		configAttributesRecycler(product.attributes)
	}

	private fun configImageRecycler(images: List<String>) {
		binding.ImageRecycler.layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
		binding.ImageRecycler.adapter = ImageAdapter(images) { item ->
			onItemSelected(item)
		}
	}

	private fun configAttributesRecycler(attributes: List<Pair<String, String>>) {
		binding.attributesRecycler.layoutManager = LinearLayoutManager(context)
		binding.attributesRecycler.adapter = AttributesAdapter(attributes)
	}

	private fun onItemSelected(item: String) {
		viewModel.currentImage.value = item
	}
}
