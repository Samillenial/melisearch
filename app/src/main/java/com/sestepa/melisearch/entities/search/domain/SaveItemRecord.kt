package com.sestepa.melisearch.entities.search.domain

import com.sestepa.melisearch.entities.search.data.SearchRepository
import javax.inject.Inject

class SaveItemRecord @Inject constructor(private val repository: SearchRepository){

	suspend operator fun invoke(item: ItemData) {
		repository.saveItemRecordToLocal(item)
	}
}
