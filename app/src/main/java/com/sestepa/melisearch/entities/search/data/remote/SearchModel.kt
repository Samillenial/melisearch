package com.sestepa.melisearch.entities.search.data.remote

import com.google.gson.annotations.SerializedName
import com.sestepa.melisearch.entities.search.domain.PagingData
import com.sestepa.melisearch.entities.search.domain.ProductData
import com.sestepa.melisearch.entities.search.domain.SearchData

data class SearchModel(
		@SerializedName("results") val products: List<ProductModel> = emptyList(),
		@SerializedName("paging") val paging: PagingModel = PagingModel()
					  ) {

	fun isEmpty(): Boolean = products.isEmpty()
}

fun SearchModel.toSearchData() = SearchData(products.map { product -> product.toProductData() }, paging.toPagingData())

data class ProductModel(

		@SerializedName("id") val id: String,
		@SerializedName("site_id") val siteId: String,
		@SerializedName("title") val title: String,
		@SerializedName("price") val price: Float,
		@SerializedName("thumbnail") val thumbnail: String,
		@SerializedName("shipping") val shipping: Shipping,
		@SerializedName("category_id") val categoryId: String = "",
					   )

fun ProductModel.toProductData() = ProductData(id, title, price.toString(), thumbnail, true, (1..5).random().toFloat())

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
