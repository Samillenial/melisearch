package com.sestepa.melisearch.entities.category.data.remote

import com.google.gson.annotations.SerializedName
import com.sestepa.melisearch.entities.category.domain.CategoryData

data class CategoryModel(
		@SerializedName("id") val id: String,
		@SerializedName("name") val name: String
					  ) {

	fun toCategoryData() = CategoryData(id, name)
}

fun CategoryData.toSiteModel() = CategoryModel(id, name)

