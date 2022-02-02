package com.sestepa.melisearch.entities.product.domain

data class QueryResultData(var products: List<ProductData> = emptyList(), var paging: PagingData) {

	fun isEmpty() = products.isEmpty()
	fun isNotEmpty() = !isEmpty()
}
