package com.sestepa.melisearch.entities.search.domain

import android.util.Log
import com.sestepa.melisearch.core.PREFIX_TAG
import com.sestepa.melisearch.entities.search.data.SearchRepository
import javax.inject.Inject

private const val TAG = PREFIX_TAG + "DeleteItemsRecordUseCase"

class DeleteItemsRecord @Inject constructor(private val repository: SearchRepository) {

	suspend fun invoke() {
		Log.i(TAG, "invoke")
		repository.deleteRecordsFromLocal()
	}
}
