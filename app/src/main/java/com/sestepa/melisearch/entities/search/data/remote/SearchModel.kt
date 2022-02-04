package com.sestepa.melisearch.entities.search.data.remote

import com.google.gson.annotations.SerializedName
import com.sestepa.melisearch.core.formatAmount
import com.sestepa.melisearch.entities.search.domain.PagingData
import com.sestepa.melisearch.entities.search.domain.ItemData
import com.sestepa.melisearch.entities.search.domain.SearchData

data class SearchModel(
		@SerializedName("results") val products: List<ProductModel> = emptyList(),
		@SerializedName("paging") val paging: PagingModel = PagingModel()
					  ) {
}

fun SearchModel.toSearchData() = SearchData(products.map { product -> product.toProductData() }, paging.toPagingData())

data class ProductModel(

		@SerializedName("id") val id: String,
		@SerializedName("site_id") val siteId: String,
		@SerializedName("title") val title: String,
		@SerializedName("price") val price: Double,
		@SerializedName("thumbnail") val thumbnail: String,
		@SerializedName("shipping") val shipping: Shipping,
		@SerializedName("category_id") val categoryId: String = "",
					   )

fun ProductModel.toProductData() = ItemData(
		id = id,
		title = title,
		price = price.formatAmount(),
		image = thumbnail,
		freeShipping = true,
		rate = (3..5).random().toFloat())

data class Shipping(
		@SerializedName("free_shipping") val freeShipping: Boolean = false,
				   )

data class PagingModel(
		@SerializedName("offset") val offset: Int = 0,
		@SerializedName("limit") val limit: Int = 0,
		@SerializedName("total") val total: Int = 0,
		@SerializedName("primary_results") val primaryResults: Int = 0
					  )

fun PagingModel.toPagingData() = PagingData(offset, limit, total)
