package com.sestepa.melisearch.entities.product.data.remote

import com.google.gson.annotations.SerializedName
import com.sestepa.melisearch.entities.product.domain.QueryResultData

data class QueryResultModel(
		@SerializedName("results") val products: List<ProductModel> = emptyList(),
		@SerializedName("paging") val paging: PagingModel = PagingModel() ){

	fun isEmpty(): Boolean = products.isEmpty()
}




fun QueryResultModel.toQueryResultData() = QueryResultData(products.map { product -> product.toProductData() }, paging.toPagingData())


