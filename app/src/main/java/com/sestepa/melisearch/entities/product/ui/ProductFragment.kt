package com.sestepa.melisearch.entities.product.ui

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.sestepa.melisearch.R
import com.sestepa.melisearch.core.PREFIX_TAG
import com.sestepa.melisearch.core.showToast
import com.sestepa.melisearch.databinding.FragmentProductBinding
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

			if(product.isEmpty()) {
				Log.e(TAG, "Fail PRODUCT download")

				requireContext().showToast(getString(R.string.try_again))
				requireActivity().onBackPressed()
			} else {
				Log.i(TAG, "Download ITEMS successful !!!")
				Log.i(TAG, product.toString())

				binding.textView.text = product.toString()
			}
		}
	}
}
