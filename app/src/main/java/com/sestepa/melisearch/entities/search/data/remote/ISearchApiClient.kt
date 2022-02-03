package com.sestepa.melisearch.entities.search.data.remote

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ISearchApiClient {

	@GET("sites/{siteId}/search")
	suspend fun getItemsByName(
			@Path("siteId") siteId: String,
			@Query("q") name: String,
			@Query("offset") offset: Int,
			@Query("limit") limit: Int
							  ): Response<SearchModel>

	@GET("sites/{siteId}/search")
	suspend fun getItemsByCategory(
			@Path("siteId") siteId: String,
			@Query("category") categoryId: String,
			@Query("offset") offset: Int,
			@Query("limit") limit: Int
								  ): Response<SearchModel>
}
