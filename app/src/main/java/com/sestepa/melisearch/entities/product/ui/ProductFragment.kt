package com.sestepa.melisearch.entities.product.ui

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.sestepa.melisearch.R
import com.sestepa.melisearch.core.showToast
import com.sestepa.melisearch.databinding.FragmentProductBinding
import com.sestepa.melisearch.entities.product.domain.ProductViewModel
import com.sestepa.melisearch.entities.search.ui.SearchByCategoryFragmentArgs

private const val TAG = "ProductFragment"

class ProductFragment: Fragment(R.layout.fragment_product) {

	private lateinit var binding: FragmentProductBinding

	private val viewModel: ProductViewModel by viewModels()
	private val args: ProductFragmentArgs by navArgs()

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)

		Log.i(TAG, "onViewCreated")
		binding = FragmentProductBinding.bind(view)

		viewModel.getProductDetail(args.productId)
		viewModel.productDetail.observe(viewLifecycleOwner){ product ->

			if(product.isEmpty()){
				Log.e(TAG, "Fail PRODUCT download")

				requireContext().showToast(getString(R.string.try_again))
				requireActivity().onBackPressed()
			}
			else{
				Log.i(TAG, "Download ITEMS successful !!!")
				Log.i(TAG, product.toString())

				binding.textView.text = product.toString()
			}
		}
	}
}
