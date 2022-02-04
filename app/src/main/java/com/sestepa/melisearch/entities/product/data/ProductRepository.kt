package com.sestepa.melisearch.entities.product.data

import android.util.Log
import com.sestepa.melisearch.entities.product.data.remote.ProductRemoteService
import com.sestepa.melisearch.entities.product.data.remote.toProductData
import com.sestepa.melisearch.entities.product.domain.ProductData
import com.sestepa.melisearch.entities.search.data.remote.SearchRemoteService
import com.sestepa.melisearch.entities.search.data.remote.toSearchData
import com.sestepa.melisearch.entities.search.domain.SearchData

private const val TAG = "ProductRepository"

class ProductRepository {

	suspend fun getProductDetail( productId: String): ProductData {
		Log.i(TAG, "getItemsByNameFromRemote")
		return ProductRemoteService().getProductDetail(productId).toProductData()
	}
}
