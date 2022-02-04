package com.sestepa.melisearch.entities.product.data.remote

import com.google.gson.annotations.SerializedName
import com.sestepa.melisearch.core.formatAmount
import com.sestepa.melisearch.entities.product.domain.ProductData

data class ProductModel(
		@SerializedName("id") val id: String = "",
		@SerializedName("title") val title: String = "",
		@SerializedName("price") val price: Double = 0.0,
		@SerializedName("pictures") val pictures: List<Pictures> = emptyList(),
		@SerializedName("condition") val condition: String = "",
		@SerializedName("accepts_mercadopago") val mercadopago: Boolean = false,
		@SerializedName("shipping") val shipping: Shipping = Shipping(),
		@SerializedName("attributes") val attributes: List<Attributes> = emptyList(),
		@SerializedName("warranty") val warranty: String = "",
					   )

data class Attributes(
		@SerializedName("name") val name: String,
		@SerializedName("value_name") val value: String,
					 )

data class Pictures(@SerializedName("url") val url: String)

data class Shipping(@SerializedName("free_shipping") val free: Boolean = false)

fun ProductModel.toProductData() = ProductData(
		id = id,
		title = title,
		price = price.formatAmount(),
		pictures = pictures.map { it.url },
		condition = condition,
		mercadopago = mercadopago,
		freeShipping = shipping.free,
		attributes = attributes.associate { it.name to it.value },
		warranty = warranty,
		rate = (3..5).random().toFloat()
											  )
