package com.sestepa.melisearch.entities.site.domain

import com.sestepa.melisearch.entities.site.data.SiteRepository

class UpdateCurrentSiteUseCase {

	suspend operator fun invoke(newSite: SiteData) = SiteRepository().updateCurrentSiteToLocal(newSite)
}
