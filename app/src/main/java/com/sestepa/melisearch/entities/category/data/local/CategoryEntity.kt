package com.sestepa.melisearch.entities.category.data.local

import com.sestepa.melisearch.core.IEmpty
import com.sestepa.melisearch.entities.category.domain.CategoryData
import com.sestepa.melisearch.entities.category.domain.DEFAULT_ID
import com.sestepa.melisearch.entities.category.domain.DEFAULT_NAME


data class CategoryEntity(
		val id: String = DEFAULT_ID,
		val name: String = DEFAULT_NAME
						 ): IEmpty {

	fun toCategoryData() = CategoryData(id, name)

	override fun isEmpty() = (id == DEFAULT_ID && name == DEFAULT_NAME)
}

fun CategoryData.toCategoryEntity() = CategoryEntity(id, name)
