package com.sestepa.melisearch.entities.product.data.remote

import com.sestepa.melisearch.core.MELI_URL_BASE
import com.sestepa.melisearch.core.RetrofitProvider
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ProductRemoteService {

	private val retrofit = RetrofitProvider(MELI_URL_BASE).create()

	suspend fun getProductDetail( productId: String ): ProductModel {
		return withContext(Dispatchers.IO) {
			val response = retrofit.create(IProductApiClient::class.java).getProductDetails(productId)
			response.body() ?: ProductModel()
		}
	}
}
