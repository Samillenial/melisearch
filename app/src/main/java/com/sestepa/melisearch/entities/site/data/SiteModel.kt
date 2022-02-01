package com.sestepa.melisearch.entities.site.data

import com.google.gson.annotations.SerializedName
import com.sestepa.melisearch.entities.site.domain.SiteData

data class SiteModel(
		@SerializedName("id") val id: String,
		@SerializedName("name") val name: String,
		@SerializedName("default_currency_id") val currencyId: String
					) {

	fun toSiteData() = SiteData(id, name, currencyId)
}

fun SiteData.toSiteModel() = SiteModel(id, name, currencyId)
