package com.sestepa.melisearch.entities.category.data.remote

import com.google.gson.annotations.SerializedName
import com.sestepa.melisearch.core.IEmpty
import com.sestepa.melisearch.entities.category.domain.CategoryData
import com.sestepa.melisearch.entities.category.domain.DEFAULT_ID
import com.sestepa.melisearch.entities.category.domain.DEFAULT_NAME

data class CategoryModel(
		@SerializedName("id") val id: String = DEFAULT_ID,
		@SerializedName("name") val name: String = DEFAULT_NAME
						): IEmpty {

	override fun isEmpty() = (id == DEFAULT_ID && name == DEFAULT_NAME)

	fun toCategoryData() = CategoryData(id, name)
}

