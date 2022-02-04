package com.sestepa.melisearch.entities.product.domain

data class ProductData(
		val id: String = "",
		val title: String = "",
		val price: String = "",
		val pictures: List<String> = emptyList(),
		val condition: String = "",
		val mercadopago: Boolean = false,
		val freeShipping: Boolean = false,
		val attributes: Map<String, String> = emptyMap(),
		val warranty: String = "",
		val rate: Float = 0F
					  ) {

	fun isEmpty() = ( id.isEmpty() && title.isEmpty() )
}
