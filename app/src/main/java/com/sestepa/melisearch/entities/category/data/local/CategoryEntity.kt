package com.sestepa.melisearch.entities.category.data.local

import com.sestepa.melisearch.entities.category.domain.CategoryData

data class CategoryEntity(
		val id: String,
		val name: String
						 ) {

	fun toCategoryData() = CategoryData(id, name)
}

fun CategoryData.toCategoryEntity() = CategoryEntity(id, name)
