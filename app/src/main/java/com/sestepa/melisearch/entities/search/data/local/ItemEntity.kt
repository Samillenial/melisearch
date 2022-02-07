package com.sestepa.melisearch.entities.search.data.local

import com.sestepa.melisearch.core.IEmpty
import com.sestepa.melisearch.entities.product.domain.DEFAULT_ID
import com.sestepa.melisearch.entities.product.domain.DEFAULT_TITLE
import com.sestepa.melisearch.entities.product.domain.ProductData

data class ItemEntity(
		var id: String = "",
		var title: String = "",
		var price: String = "",
		var image: String = "",
		var freeShipping: Boolean = false,
		var rate: Float = 0F
					 ): IEmpty {

	override fun isEmpty() = (id == DEFAULT_ID && title == DEFAULT_TITLE)

	fun toProductData() = ProductData(
			id = id,
			title = title,
			price = price,
			images = listOf(image),
			freeShipping = freeShipping,
			rate = rate
									 )
}

fun ProductData.toItemEntity() = ItemEntity(
		id = id,
		title = title,
		price = price, image = images[0],
		freeShipping = freeShipping,
		rate = rate
										   )

