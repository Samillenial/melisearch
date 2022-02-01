package com.sestepa.melisearch.entities.product.data.remote

import com.google.gson.annotations.SerializedName
import com.sestepa.melisearch.entities.product.domain.ProductData

data class ProductModel(

		@SerializedName("id") val id: String,
		@SerializedName("site_id") val siteId: String,
		@SerializedName("title") val title: String,
		@SerializedName("price") val price: Int,
		@SerializedName("currency_id") val currencyId: String,
		@SerializedName("available_quantity") val availableQuantity: Int,
		@SerializedName("sold_quantity") val soldQuantity: Int,
		@SerializedName("buying_mode") val buyingMode: String,
		@SerializedName("condition") val condition: String,
		@SerializedName("permalink") val permalink: String,
		@SerializedName("thumbnail") val thumbnail: String,
		@SerializedName("thumbnail_id") val thumbnailId: String,
		@SerializedName("accepts_mercadopago") val acceptsMercadopago: Boolean,
		@SerializedName("shipping") val shipping: Shipping,
		@SerializedName("category_id") val categoryId: String = "",
					   )

fun ProductModel.toProductData() = ProductData( id, title, price.toString(), thumbnail, true, (1..5).random().toFloat())
