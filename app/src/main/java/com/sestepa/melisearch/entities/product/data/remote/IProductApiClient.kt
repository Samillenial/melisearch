package com.sestepa.melisearch.entities.product.data.remote

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface IProductApiClient {

	@GET("sites/{siteId}/search")
	suspend fun getProductQuery(@Path("siteId")siteId: String,
								@Query("q") query: String,
								@Query("offset") offset: Int,
								@Query( "limit") limit: Int
							   ): Response<QueryResultModel>
}
