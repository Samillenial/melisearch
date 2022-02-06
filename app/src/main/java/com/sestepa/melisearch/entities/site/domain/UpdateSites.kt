package com.sestepa.melisearch.entities.site.domain

import com.sestepa.melisearch.entities.site.data.SiteRepository
import javax.inject.Inject

class UpdateSites @Inject constructor(private val repository: SiteRepository) {

	suspend operator fun invoke(newSites: List<SiteData>): Unit =
		repository.updateSitesToLocal(newSites)
}
