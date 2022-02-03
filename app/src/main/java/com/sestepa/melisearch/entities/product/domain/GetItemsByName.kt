package com.sestepa.melisearch.entities.product.domain

import com.sestepa.melisearch.entities.search.data.SearchRepository
import com.sestepa.melisearch.entities.search.domain.PagingData
import com.sestepa.melisearch.entities.search.domain.SearchData

class GetItemsByName {

	suspend operator fun invoke(siteId: String, query: String, paging: PagingData): SearchData {
		val repository = SearchRepository()

		return repository.getItemsByNameFromRemote(siteId, query, paging)
	}
}
