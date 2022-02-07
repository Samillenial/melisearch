package com.sestepa.melisearch.entities.site.data.local

import com.sestepa.melisearch.core.IEmpty
import com.sestepa.melisearch.entities.site.domain.DEFAULT_ID
import com.sestepa.melisearch.entities.site.domain.DEFAULT_NAME
import com.sestepa.melisearch.entities.site.domain.SiteData

data class SiteEntity(
		val id: String = DEFAULT_ID,
		val name: String = DEFAULT_NAME
					 ): IEmpty {

	override fun isEmpty() = (id == DEFAULT_ID && name == DEFAULT_NAME)

	fun toSiteData(): SiteData = SiteData(id, name)
}

fun SiteData.toSiteEntity(): SiteEntity = SiteEntity(id, name)
