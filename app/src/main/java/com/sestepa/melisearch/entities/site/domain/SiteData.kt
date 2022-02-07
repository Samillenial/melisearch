package com.sestepa.melisearch.entities.site.domain

import android.os.Parcelable
import com.sestepa.melisearch.core.IEmpty
import kotlinx.parcelize.Parcelize

const val DEFAULT_ID = ""
const val DEFAULT_NAME = ""

@Parcelize
data class SiteData(
		val id: String = DEFAULT_ID,
		val name: String = DEFAULT_NAME
				   ): Comparable<SiteData>, Parcelable, IEmpty {

	override fun compareTo(other: SiteData) = name.compareTo(other.name)

	override fun isEmpty() = (id == DEFAULT_ID && name == DEFAULT_NAME)
}
