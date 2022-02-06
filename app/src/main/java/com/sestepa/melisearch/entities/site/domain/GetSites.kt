package com.sestepa.melisearch.entities.site.domain

import com.sestepa.melisearch.entities.site.data.SiteRepository
import javax.inject.Inject

class GetSites @Inject constructor( private val repository: SiteRepository) {

	suspend operator fun invoke(): List<SiteData> =
		repository.getSitesFromLocal().ifEmpty { repository.getSitesFromRemote() }
}
