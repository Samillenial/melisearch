package com.sestepa.melisearch.entities.site.data

import android.util.Log
import com.sestepa.melisearch.entities.site.data.local.SitesProvider
import com.sestepa.melisearch.entities.site.data.local.toSiteEntity
import com.sestepa.melisearch.entities.site.data.remote.SiteRemoteService
import com.sestepa.melisearch.entities.site.domain.SiteData
import javax.inject.Inject

private const val TAG = "SiteRepository"

class SiteRepository @Inject constructor(private val remoteService: SiteRemoteService) {

	suspend fun getSitesFromRemote(): List<SiteData> {
		Log.i(TAG, "getSitesFromRemote")
		return remoteService.getSites().map { model -> model.toSiteData() }
	}

	suspend fun getSitesFromLocal(): List<SiteData> {
		Log.i(TAG, "getSitesFromLocal")
		return SitesProvider.getSites().map { entity -> entity.toSiteData() }
	}

	suspend fun updateSitesToLocal(newSites: List<SiteData>) {
		Log.i(TAG, "updateSitesToLocal")
		return SitesProvider.updateSites(newSites.map { it.toSiteEntity() })
	}

	suspend fun updateCurrentSiteToLocal(newSite: SiteData) {
		Log.i(TAG, "updateCurrentSiteToLocal")
		SitesProvider.updateCurrentSite(newSite.toSiteEntity())
	}

	suspend fun getCurrentSiteToLocal(): SiteData {
		Log.i(TAG, "getCurrentSiteToLocal")
		return SitesProvider.getCurrentSite().toSiteData()
	}
}
