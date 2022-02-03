package com.sestepa.melisearch.entities.search.data.remote

import com.sestepa.melisearch.core.MELI_URL_BASE
import com.sestepa.melisearch.core.RetrofitProvider
import com.sestepa.melisearch.entities.search.domain.PagingData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class SearchRemoteService {

	private val retrofit = RetrofitProvider(MELI_URL_BASE).create()

	suspend fun getItemsByName(siteId: String, name: String, paging: PagingData): SearchModel {
		return withContext(Dispatchers.IO) {
			val response = retrofit.create(ISearchApiClient::class.java).getItemsByName(siteId, name, paging.offset, paging.limit)
			response.body() ?: SearchModel()
		}
	}

	suspend fun getItemsByCategory(siteId: String, categoryId: String, paging: PagingData): SearchModel {
		return withContext(Dispatchers.IO) {
			val response = retrofit.create(ISearchApiClient::class.java).getItemsByCategory(siteId, categoryId, paging.offset, paging.limit)
			response.body() ?: SearchModel()
		}
	}
}
