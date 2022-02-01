package com.sestepa.melisearch.entities.site.domain

import com.sestepa.melisearch.entities.site.data.SiteRepository

class GetCurrentSite {

	suspend operator fun invoke() = SiteRepository().getCurrentSiteToLocal()
}
