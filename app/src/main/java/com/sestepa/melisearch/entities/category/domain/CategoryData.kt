package com.sestepa.melisearch.entities.category.domain

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class CategoryData(
		val id: String,
		val name: String
					   ): Comparable<CategoryData>, Parcelable {

	override fun compareTo(other: CategoryData) = name.compareTo(other.name)
}
