package com.sestepa.melisearch.entities.search.domain

data class SearchData(val items: List<ItemData>, var paging: PagingData) {

	fun isEmpty() = items.isEmpty()
	fun isNotEmpty() = !isEmpty()
}


data class ItemData(var id: String = "", var title: String = "", var price: String = "", var image: String = "", var freeShipping: Boolean = false, var rate: Float = 0F)

data class PagingData(val offset: Int = 0, val limit: Int = 0, val total: Int = 0)
