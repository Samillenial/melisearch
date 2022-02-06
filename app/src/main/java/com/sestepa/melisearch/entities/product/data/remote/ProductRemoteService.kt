package com.sestepa.melisearch.entities.product.data.remote

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ProductRemoteService @Inject constructor( private val api: IProductApiClient){

	suspend fun getProductDetail( productId: String ): ProductModel {
		return withContext(Dispatchers.IO) {
			api.getProductDetails(productId).body() ?: ProductModel()
		}
	}
}
