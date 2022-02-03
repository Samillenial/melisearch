package com.sestepa.melisearch.entities.search.data

import android.util.Log
import com.sestepa.melisearch.entities.search.data.local.ProductEntity
import com.sestepa.melisearch.entities.search.data.local.ProductRecordDAO
import com.sestepa.melisearch.entities.search.data.local.toProductEntity
import com.sestepa.melisearch.entities.search.data.remote.SearchRemoteService
import com.sestepa.melisearch.entities.search.data.remote.toSearchData
import com.sestepa.melisearch.entities.search.domain.PagingData
import com.sestepa.melisearch.entities.search.domain.ProductData
import com.sestepa.melisearch.entities.search.domain.SearchData

private const val TAG = "ProductRepository"

class SearchRepository {

	suspend fun getItemsByNameFromRemote(siteId: String, name: String, paging: PagingData): SearchData {
		Log.i(TAG, "getItemsByNameFromRemote")
		return SearchRemoteService().getItemsByName(siteId, name, paging).toSearchData()
	}

	suspend fun getItemsByCategoryFromRemote(siteId: String, categoryId: String, paging: PagingData): SearchData {
		Log.i(TAG, "getItemsByCategoryFromApi")
		return SearchRemoteService().getItemsByCategory(siteId, categoryId, paging).toSearchData()
	}

	suspend fun saveProductRecordToLocal(product: ProductData) {
		Log.i(TAG, "saveProductRecordToLocal")
		ProductRecordDAO.saveRecord(product.toProductEntity())
	}

	suspend fun getRecordsFromLocal(): List<ProductEntity> {
		Log.i(TAG, "saveProductRecordToLocal")
		return ProductRecordDAO.getRecords()
	}

	suspend fun deleteRecordsFromLocal() {
		Log.i(TAG, "deleteRecordsFromLocal")
		ProductRecordDAO.deleteRecords()
	}

	suspend fun deleteRecordFromLocal(product: ProductData) {
		Log.i(TAG, "deleteRecordFromLocal")
		ProductRecordDAO.deleteRecord(product.toProductEntity())
	}
}

