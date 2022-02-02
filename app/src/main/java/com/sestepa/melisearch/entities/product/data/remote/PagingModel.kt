package com.sestepa.melisearch.entities.product.data.remote

import com.google.gson.annotations.SerializedName
import com.sestepa.melisearch.entities.product.domain.PagingData

data class PagingModel(
		@SerializedName("offset") val offset: Int = 0,
		@SerializedName("limit") val limit: Int = 0,
		@SerializedName("total") val total: Int = 0,
		@SerializedName("primary_results") val primaryResults: Int = 0
					  )

fun PagingModel.toPagingData() = PagingData(offset, limit, total)
