package com.sestepa.melisearch.entities.search.domain

import com.sestepa.melisearch.entities.search.data.SearchRepository

class DeleteProductsRecord {

	suspend fun invoke() {
		SearchRepository().deleteRecordsFromLocal()
	}
}
