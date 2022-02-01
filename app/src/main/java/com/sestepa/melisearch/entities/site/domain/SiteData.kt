package com.sestepa.melisearch.entities.site.domain

data class SiteData(
		val id: String,
		val name: String,
		val currencyId: String
				   ): Comparable<SiteData> {

	override fun compareTo(other: SiteData) = name.compareTo(other.name)
}
