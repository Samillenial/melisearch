package com.sestepa.melisearch.entities.search.domain

import com.sestepa.melisearch.entities.search.data.SearchRepository
import javax.inject.Inject

class DeleteItemsRecord @Inject constructor( private val repository: SearchRepository){

	suspend fun invoke() {
		repository.deleteRecordsFromLocal()
	}
}
