package com.sestepa.melisearch.entities.category.domain

data class CategoryData(
		val id: String,
		val name: String
					   ): Comparable<CategoryData> {

	override fun compareTo(other: CategoryData) = name.compareTo(other.name)
}
