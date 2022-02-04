package com.sestepa.melisearch.entities.site.domain

import com.sestepa.melisearch.entities.site.data.SiteRepository

class GetSites {

	suspend operator fun invoke(): List<SiteData> {
		val repository = SiteRepository()

		return repository.getSitesFromLocal().ifEmpty {
			repository.getSitesFromRemote()
		}
	}
}
