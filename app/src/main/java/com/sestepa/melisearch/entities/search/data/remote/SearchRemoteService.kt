package com.sestepa.melisearch.entities.search.data.remote

import com.sestepa.melisearch.entities.search.domain.PagingData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class SearchRemoteService @Inject constructor( private val api: ISearchApiClient){

	suspend fun getItemsByName(siteId: String, name: String, paging: PagingData): SearchModel {
		return withContext(Dispatchers.IO) {
			api.getItemsByName(siteId, name, paging.offset, paging.limit).body() ?: SearchModel()
		}
	}

	suspend fun getItemsByCategory(siteId: String, categoryId: String, paging: PagingData): SearchModel {
		return withContext(Dispatchers.IO) {
			api.getItemsByCategory(siteId, categoryId, paging.offset, paging.limit).body() ?: SearchModel()
		}
	}
}
