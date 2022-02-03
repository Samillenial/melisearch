package com.sestepa.melisearch.entities.site.data.local

import com.sestepa.melisearch.entities.site.domain.SiteData

data class SiteEntity(
		val id: String,
		val name: String,
		val currencyId: String
					 ) {

	fun toSiteData(): SiteData = SiteData(id, name, currencyId)
}

fun SiteData.toSiteEntity(): SiteEntity = SiteEntity(id, name, currencyId)
