package com.sestepa.melisearch.entities.search.domain

import com.sestepa.melisearch.entities.search.data.SearchRepository
import com.sestepa.melisearch.entities.search.domain.PagingData
import com.sestepa.melisearch.entities.search.domain.SearchData
import javax.inject.Inject

class GetItemsByName @Inject constructor(private val repository: SearchRepository)  {

	suspend operator fun invoke(siteId: String, name: String, paging: PagingData): SearchData =
		repository.getItemsByNameFromRemote(siteId, name, paging)
}
