package com.sestepa.melisearch.entities.search.domain

import com.sestepa.melisearch.entities.search.data.local.ProductRecordDAO
import com.sestepa.melisearch.entities.search.data.local.toProductData

class GetSearchRecord {

	suspend operator fun invoke(): SearchData {
		val products = ProductRecordDAO.getRecords().reversed().map { entity -> entity.toProductData() }
		val paging = PagingData(total = products.size)

		return SearchData(products, paging)
	}
}
