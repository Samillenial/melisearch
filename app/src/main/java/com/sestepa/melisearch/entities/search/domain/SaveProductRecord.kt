package com.sestepa.melisearch.entities.search.domain

import com.sestepa.melisearch.entities.search.data.SearchRepository

class SaveProductRecord {

	suspend operator fun invoke(product: ProductData) {
		SearchRepository().saveProductRecordToLocal(product)
	}
}
