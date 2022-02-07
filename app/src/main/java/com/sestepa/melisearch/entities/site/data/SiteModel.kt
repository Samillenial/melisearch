package com.sestepa.melisearch.entities.site.data

import com.google.gson.annotations.SerializedName
import com.sestepa.melisearch.core.IEmpty
import com.sestepa.melisearch.entities.site.domain.DEFAULT_ID
import com.sestepa.melisearch.entities.site.domain.DEFAULT_NAME
import com.sestepa.melisearch.entities.site.domain.SiteData

data class SiteModel(
		@SerializedName("id") val id: String = DEFAULT_ID,
		@SerializedName("name") val name: String = DEFAULT_NAME,
					): IEmpty {

	override fun isEmpty() = (id == DEFAULT_ID && name == DEFAULT_NAME)

	fun toSiteData() = SiteData(id, name)
}
