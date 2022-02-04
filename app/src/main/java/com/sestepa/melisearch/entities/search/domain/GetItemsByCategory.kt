package com.sestepa.melisearch.entities.search.domain

import com.sestepa.melisearch.entities.search.data.SearchRepository
import com.sestepa.melisearch.entities.search.domain.PagingData
import com.sestepa.melisearch.entities.search.domain.SearchData

class GetItemsByCategory {

	suspend operator fun invoke(siteId: String, categoryId: String, paging: PagingData): SearchData {
		val repository = SearchRepository()

		return repository.getItemsByCategoryFromRemote(siteId, categoryId, paging)
	}
}
