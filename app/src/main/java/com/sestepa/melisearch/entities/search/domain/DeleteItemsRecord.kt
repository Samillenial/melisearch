package com.sestepa.melisearch.entities.search.domain

import com.sestepa.melisearch.entities.search.data.SearchRepository

class DeleteItemsRecord {

	suspend fun invoke() {
		SearchRepository().deleteRecordsFromLocal()
	}
}
