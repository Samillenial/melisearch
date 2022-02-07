package com.sestepa.melisearch.entities.product.domain

import com.sestepa.melisearch.core.IEmpty

const val DEFAULT_ID = ""
const val DEFAULT_TITLE = ""

data class ProductData(
		val id: String = DEFAULT_ID,
		val title: String = DEFAULT_TITLE,
		val price: String = "",
		val images: List<String> = emptyList(),
		val condition: String = "",
		val mercadopago: Boolean = false,
		val freeShipping: Boolean = false,
		val attributes: Map<String, String> = emptyMap(),
		val rate: Float = 0F
					  ): IEmpty {

	override fun isEmpty() = (id == DEFAULT_ID && title == DEFAULT_TITLE)
}
