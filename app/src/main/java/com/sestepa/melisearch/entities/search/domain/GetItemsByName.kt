package com.sestepa.melisearch.entities.search.domain

import com.sestepa.melisearch.entities.search.data.SearchRepository
import com.sestepa.melisearch.entities.search.domain.PagingData
import com.sestepa.melisearch.entities.search.domain.SearchData

class GetItemsByName {

	suspend operator fun invoke(siteId: String, name: String, paging: PagingData): SearchData {
		val repository = SearchRepository()

		return repository.getItemsByNameFromRemote(siteId, name, paging)
	}
}
