package com.sestepa.melisearch.entities.site.domain

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class SiteData(
		val id: String,
		val name: String,
		val currencyId: String
				   ): Comparable<SiteData>, Parcelable {

	override fun compareTo(other: SiteData) = name.compareTo(other.name)
}
