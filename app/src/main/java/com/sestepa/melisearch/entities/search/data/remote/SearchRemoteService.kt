package com.sestepa.melisearch.entities.search.data.remote

import android.util.Log
import com.sestepa.melisearch.core.PREFIX_TAG
import com.sestepa.melisearch.entities.search.domain.PagingData
import kotlinx.coroutines.withContext
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

private const val TAG = PREFIX_TAG + "SearchRemoteService"

class SearchRemoteService @Inject constructor(private val dispatcher: CoroutineContext, private val api: ISearchApiClient) {

	suspend fun getItemsByName(siteId: String, name: String, paging: PagingData): SearchModel {
		Log.i(TAG, "getItemsByName")
		return withContext(dispatcher) {
			try {
				api.getItemsByName(siteId, name, paging.offset, paging.limit).body() ?: SearchModel()
			} catch(e: Exception) {
				Log.e(TAG, "getItemsByName Exception ${e.message}")
				SearchModel()
			}
		}
	}

	suspend fun getItemsByCategory(siteId: String, categoryId: String, paging: PagingData): SearchModel {
		Log.i(TAG, "getItemsByCategory")
		return withContext(dispatcher) {
			try {
				api.getItemsByCategory(siteId, categoryId, paging.offset, paging.limit).body() ?: SearchModel()
			} catch(e: Exception) {
				Log.e(TAG, "getItemsByCategory Exception ${e.message}")
				SearchModel()
			}
		}
	}
}
