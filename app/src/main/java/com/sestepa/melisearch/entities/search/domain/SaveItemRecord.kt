package com.sestepa.melisearch.entities.search.domain

import com.sestepa.melisearch.entities.search.data.SearchRepository

class SaveItemRecord {

	suspend operator fun invoke(item: ItemData) {
		SearchRepository().saveItemRecordToLocal(item)
	}
}
