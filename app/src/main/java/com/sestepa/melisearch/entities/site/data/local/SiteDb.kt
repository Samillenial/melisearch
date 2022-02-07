package com.sestepa.melisearch.entities.site.data.local

import android.util.Log
import com.sestepa.melisearch.core.PREFIX_TAG
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton
import kotlin.coroutines.CoroutineContext

private const val TAG = PREFIX_TAG + "SiteDb"

@Singleton
class SiteDb @Inject constructor(private val dispatcher: CoroutineContext) {

	private var sites: List<SiteEntity> = emptyList()
	private var currentSite: SiteEntity = SiteEntity()

	suspend fun getSites(): List<SiteEntity> {
		Log.i(TAG, "getSites")
		return withContext(dispatcher) {
			sites
		}
	}

	suspend fun updateSites(siteList: List<SiteEntity>) {
		Log.i(TAG, "updateSites")
		withContext(dispatcher) {
			sites = siteList
		}
	}

	suspend fun getCurrentSite(): SiteEntity {
		Log.i(TAG, "getCurrentSite")
		return withContext(dispatcher) {
			currentSite
		}
	}


	suspend fun updateCurrentSite(newSite: SiteEntity) {
		Log.i(TAG, "updateCurrentSite")
		withContext(dispatcher) {
			currentSite = newSite
		}
	}
}

