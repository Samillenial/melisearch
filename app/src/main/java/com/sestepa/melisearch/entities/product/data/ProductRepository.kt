package com.sestepa.melisearch.entities.product.data

import android.util.Log
import com.sestepa.melisearch.core.PREFIX_TAG
import com.sestepa.melisearch.entities.product.data.remote.ProductRemoteService
import com.sestepa.melisearch.entities.product.data.remote.toProductData
import com.sestepa.melisearch.entities.product.domain.ProductData
import javax.inject.Inject

private const val TAG = PREFIX_TAG + "ProductRepository"

class ProductRepository @Inject constructor(private val remoteService: ProductRemoteService) {

	suspend fun getProductDetail(productId: String): ProductData {
		Log.i(TAG, "getProductDetail")
		return remoteService.getProductDetail(productId).toProductData()
	}
}
