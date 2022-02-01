package com.sestepa.melisearch.entities.site.data.remote

import com.sestepa.melisearch.entities.site.data.SiteModel
import retrofit2.Response
import retrofit2.http.GET

interface ISiteApiClient {

	@GET("sites")
	suspend fun getSites(): Response<List<SiteModel>>
}
