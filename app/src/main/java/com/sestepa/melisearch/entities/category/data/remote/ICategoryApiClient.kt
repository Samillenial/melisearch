package com.sestepa.melisearch.entities.category.data.remote

import com.sestepa.melisearch.entities.search.data.remote.SearchModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ICategoryApiClient {

	@GET("sites/{siteId}/categories")
	suspend fun getCategories(@Path("siteId") siteId: String): Response<List<CategoryModel>>

	@GET("sites/{siteId}/search")
	suspend fun getItemsByCategory(
			@Path("siteId") siteId: String,
			@Query("category") category: String,
								  ): Response<SearchModel>

}
