package com.sestepa.melisearch.entities.site.data.local

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class SitesProvider {

	companion object {

		private var sites: List<SiteEntity> = emptyList()
		private var currentSite: SiteEntity = SiteEntity("", "", "")

		suspend fun getSites(): List<SiteEntity> {
			return withContext(Dispatchers.IO) {
				sites
			}
		}

		suspend fun updateSites(siteList: List<SiteEntity>) {
			withContext(Dispatchers.IO) {
				sites = siteList
			}
		}

		suspend fun getCurrentSite(): SiteEntity {
			return withContext(Dispatchers.IO) {
				currentSite
			}
		}

		suspend fun updateCurrentSite(newSite: SiteEntity) {
			withContext(Dispatchers.IO) {
				currentSite = newSite
			}
		}
	}
}

