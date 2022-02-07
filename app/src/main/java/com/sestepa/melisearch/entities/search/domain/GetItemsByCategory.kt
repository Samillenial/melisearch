package com.sestepa.melisearch.entities.search.domain

import android.util.Log
import com.sestepa.melisearch.core.PREFIX_TAG
import com.sestepa.melisearch.entities.search.data.SearchRepository
import javax.inject.Inject

private const val TAG = PREFIX_TAG + "GetItemsByCategory"

class GetItemsByCategory @Inject constructor(private val repository: SearchRepository) {

	suspend operator fun invoke(siteId: String, categoryId: String, paging: PagingData): SearchData {
		Log.i(TAG, "invoke")
		return repository.getItemsByCategoryFromRemote(siteId, categoryId, paging)
	}
}
