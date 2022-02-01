package com.sestepa.melisearch.entities.site.data.remote

import com.sestepa.melisearch.core.MELI_URL_BASE
import com.sestepa.melisearch.core.RetrofitProvider
import com.sestepa.melisearch.entities.site.data.SiteModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class SiteRemoteService {

	private val retrofit = RetrofitProvider(MELI_URL_BASE).create()

	suspend fun getSites(): List<SiteModel> {
		return withContext(Dispatchers.IO) {
			val response = retrofit.create(ISiteApiClient::class.java).getSites()
			response.body() ?: emptyList()
		}
	}
}
