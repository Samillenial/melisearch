package com.sestepa.melisearch.entities.product.domain

import android.util.Log
import com.sestepa.melisearch.core.PREFIX_TAG
import com.sestepa.melisearch.entities.product.data.ProductRepository
import javax.inject.Inject

private const val TAG = PREFIX_TAG + "GetProductDetailUseCase"

class GetProductDetail @Inject constructor(private val repository: ProductRepository) {

	suspend operator fun invoke(productId: String): ProductData {
		Log.i(TAG, "invoke")
		return repository.getProductDetail(productId)
	}
}
