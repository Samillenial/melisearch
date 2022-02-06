package com.sestepa.melisearch.entities.site.data.remote

import com.sestepa.melisearch.entities.site.data.SiteModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class SiteRemoteService @Inject constructor(private val api: ISiteApiClient){

	suspend fun getSites(): List<SiteModel> {
		return withContext(Dispatchers.IO) {
			api.getSites().body() ?: emptyList()
		}
	}
}
