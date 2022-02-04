package com.sestepa.melisearch.entities.search.data

import android.util.Log
import com.sestepa.melisearch.entities.search.data.local.ItemEntity
import com.sestepa.melisearch.entities.search.data.local.ItemRecordDAO
import com.sestepa.melisearch.entities.search.data.local.toItemEntity
import com.sestepa.melisearch.entities.search.data.remote.SearchRemoteService
import com.sestepa.melisearch.entities.search.data.remote.toSearchData
import com.sestepa.melisearch.entities.search.domain.PagingData
import com.sestepa.melisearch.entities.search.domain.ItemData
import com.sestepa.melisearch.entities.search.domain.SearchData

private const val TAG = "SearchRepository"

class SearchRepository {

	suspend fun getItemsByNameFromRemote(siteId: String, name: String, paging: PagingData): SearchData {
		Log.i(TAG, "getItemsByNameFromRemote")
		return SearchRemoteService().getItemsByName(siteId, name, paging).toSearchData()
	}

	suspend fun getItemsByCategoryFromRemote(siteId: String, categoryId: String, paging: PagingData): SearchData {
		Log.i(TAG, "getItemsByCategoryFromApi")
		return SearchRemoteService().getItemsByCategory(siteId, categoryId, paging).toSearchData()
	}

	suspend fun saveItemRecordToLocal(item: ItemData) {
		Log.i(TAG, "saveItemRecordToLocal")
		ItemRecordDAO.saveRecord(item.toItemEntity())
	}

	suspend fun getRecordsFromLocal(): List<ItemEntity> {
		Log.i(TAG, "getRecordsFromLocal")
		return ItemRecordDAO.getRecords()
	}

	suspend fun deleteRecordsFromLocal() {
		Log.i(TAG, "deleteRecordsFromLocal")
		ItemRecordDAO.deleteRecords()
	}

	suspend fun deleteRecordFromLocal(product: ItemData) {
		Log.i(TAG, "deleteRecordFromLocal")
		ItemRecordDAO.deleteRecord(product.toItemEntity())
	}
}

