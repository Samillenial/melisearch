package com.sestepa.melisearch.entities.search.domain

import com.sestepa.melisearch.entities.search.data.local.ItemRecordDAO
import com.sestepa.melisearch.entities.search.data.local.toItemData
import javax.inject.Inject

class GetSearchRecord @Inject constructor() {

	suspend operator fun invoke(): SearchData {
		val items = ItemRecordDAO.getRecords().reversed().map { entity -> entity.toItemData() }
		val paging = PagingData(total = items.size)

		return SearchData(items, paging)
	}
}
