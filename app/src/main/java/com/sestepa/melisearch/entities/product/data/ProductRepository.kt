package com.sestepa.melisearch.entities.product.data

import android.util.Log
import com.sestepa.melisearch.entities.product.data.remote.ProductRemoteService
import com.sestepa.melisearch.entities.product.data.remote.toProductData
import com.sestepa.melisearch.entities.product.domain.PagingData
import com.sestepa.melisearch.entities.product.domain.ProductData

private const val TAG = "ProductRepository"

class ProductRepository {

	suspend fun getProductQueryFromRemote(siteId: String, query: String, paging: PagingData): List<ProductData>{
		Log.i(TAG, "getProductQueryFromRemote")
		return ProductRemoteService().getProductQuery(siteId, query, paging).map { model -> model.toProductData() }

	}

}

