package com.sestepa.melisearch.entities.search.domain

import com.sestepa.melisearch.core.IEmpty
import com.sestepa.melisearch.entities.product.domain.ProductData

data class SearchData(val items: List<ProductData>, var paging: PagingData): IEmpty {

	override fun isEmpty() = items.isEmpty()
}

data class PagingData(val offset: Int = 0, val limit: Int = 0, val total: Int = 0)
