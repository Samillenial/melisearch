package com.sestepa.melisearch.entities.search.data

import android.util.Log
import com.sestepa.melisearch.core.PREFIX_TAG
import com.sestepa.melisearch.entities.product.domain.ProductData
import com.sestepa.melisearch.entities.search.data.local.ItemEntity
import com.sestepa.melisearch.entities.search.data.local.ItemRecordDb
import com.sestepa.melisearch.entities.search.data.local.toItemEntity
import com.sestepa.melisearch.entities.search.data.remote.SearchRemoteService
import com.sestepa.melisearch.entities.search.data.remote.toSearchData
import com.sestepa.melisearch.entities.search.domain.PagingData
import com.sestepa.melisearch.entities.search.domain.SearchData
import javax.inject.Inject

private const val TAG = PREFIX_TAG + "SearchRepository"

class SearchRepository @Inject constructor(private val remoteService: SearchRemoteService, private val localDb: ItemRecordDb) {

	suspend fun getItemsByNameFromRemote(siteId: String, name: String, paging: PagingData): SearchData {
		Log.i(TAG, "getItemsByNameFromRemote")
		return remoteService.getItemsByName(siteId, name, paging).toSearchData()
	}

	suspend fun getItemsByCategoryFromRemote(siteId: String, categoryId: String, paging: PagingData): SearchData {
		Log.i(TAG, "getItemsByCategoryFromApi")
		return remoteService.getItemsByCategory(siteId, categoryId, paging).toSearchData()
	}

	suspend fun saveItemRecordToLocal(item: ProductData) {
		Log.i(TAG, "saveItemRecordToLocal")
		localDb.saveRecord(item.toItemEntity())
	}

	suspend fun getRecordsFromLocal(): List<ItemEntity> {
		Log.i(TAG, "getRecordsFromLocal")
		return localDb.getRecords()
	}

	suspend fun deleteRecordsFromLocal() {
		Log.i(TAG, "deleteRecordsFromLocal")
		localDb.deleteRecords()
	}

	suspend fun deleteRecordFromLocal(product: ProductData) {
		Log.i(TAG, "deleteRecordFromLocal")
		localDb.deleteRecord(product.toItemEntity())
	}
}

