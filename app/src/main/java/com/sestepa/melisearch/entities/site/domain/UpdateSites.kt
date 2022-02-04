package com.sestepa.melisearch.entities.site.domain

import com.sestepa.melisearch.entities.site.data.SiteRepository

class UpdateSites {

	suspend operator fun invoke(newSites: List<SiteData>) = SiteRepository().updateSitesToLocal(newSites)
}
