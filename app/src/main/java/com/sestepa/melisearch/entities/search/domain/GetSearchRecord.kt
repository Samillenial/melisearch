package com.sestepa.melisearch.entities.search.domain

import android.util.Log
import com.sestepa.melisearch.core.PREFIX_TAG
import com.sestepa.melisearch.entities.search.data.SearchRepository
import javax.inject.Inject

private const val TAG = PREFIX_TAG + "GetSearchRecordUseCase"

class GetSearchRecord @Inject constructor(private val repository: SearchRepository) {

	suspend operator fun invoke(): SearchData {
		Log.i(TAG, "invoke")
		val items = repository.getRecordsFromLocal().reversed().map { entity -> entity.toProductData() }
		val paging = PagingData(total = items.size)

		return SearchData(items, paging)
	}
}
