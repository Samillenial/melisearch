package com.sestepa.melisearch.entities.site.domain

import com.sestepa.melisearch.entities.site.data.SiteRepository
import javax.inject.Inject

class UpdateCurrentSite @Inject constructor(private val repository: SiteRepository){

	suspend operator fun invoke(newSite: SiteData): Unit =
		repository.updateCurrentSiteToLocal(newSite)
}
