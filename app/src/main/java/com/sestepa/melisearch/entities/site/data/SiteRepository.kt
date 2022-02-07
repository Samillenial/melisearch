package com.sestepa.melisearch.entities.site.data

import android.util.Log
import com.sestepa.melisearch.core.PREFIX_TAG
import com.sestepa.melisearch.entities.site.data.local.SiteDb
import com.sestepa.melisearch.entities.site.data.local.toSiteEntity
import com.sestepa.melisearch.entities.site.data.remote.SiteRemoteService
import com.sestepa.melisearch.entities.site.domain.SiteData
import javax.inject.Inject

private const val TAG = PREFIX_TAG + "SiteRepository"

class SiteRepository @Inject constructor(private val remoteService: SiteRemoteService, private val localDb: SiteDb) {

	suspend fun getSitesFromRemote(): List<SiteData> {
		Log.i(TAG, "getSitesFromRemote")
		return remoteService.getSites().map { model -> model.toSiteData() }
	}

	suspend fun getSitesFromLocal(): List<SiteData> {
		Log.i(TAG, "getSitesFromLocal")
		return localDb.getSites().map { entity -> entity.toSiteData() }
	}

	suspend fun updateSitesToLocal(newSites: List<SiteData>) {
		Log.i(TAG, "updateSitesToLocal")
		return localDb.updateSites(newSites.map { it.toSiteEntity() })
	}

	suspend fun updateCurrentSiteToLocal(newSite: SiteData) {
		Log.i(TAG, "updateCurrentSiteToLocal")
		localDb.updateCurrentSite(newSite.toSiteEntity())
	}

	suspend fun getCurrentSiteToLocal(): SiteData {
		Log.i(TAG, "getCurrentSiteToLocal")
		return localDb.getCurrentSite().toSiteData()
	}
}
