package com.sestepa.melisearch.entities.category.data.remote

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ICategoryApiClient {

	@GET("sites/{siteId}/categories")
	suspend fun getCategories(@Path("siteId") siteId: String): Response<List<CategoryModel>>

	@GET("{siteId}/categories/{id}")
	suspend fun getCategoryInfo(
			@Path("siteId") siteId: String,
			@Path("id") id: String
							   ): Response<List<CategoryModel>>

}
