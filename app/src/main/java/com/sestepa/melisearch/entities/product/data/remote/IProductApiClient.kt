package com.sestepa.melisearch.entities.product.data.remote

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface IProductApiClient {

	@GET("items/{id}")
	suspend fun getProductDetails(@Path("id") id: String): Response<ProductModel>
}
