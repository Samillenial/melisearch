package com.sestepa.melisearch.entities.site.data.remote

import android.util.Log
import com.sestepa.melisearch.core.PREFIX_TAG
import com.sestepa.melisearch.entities.site.data.SiteModel
import kotlinx.coroutines.withContext
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

private const val TAG = PREFIX_TAG + "SiteRemoteService"

class SiteRemoteService @Inject constructor(private val dispatcher: CoroutineContext, private val api: ISiteApiClient) {

	suspend fun getSites(): List<SiteModel> {
		Log.i(TAG, "getSites")

		return withContext(dispatcher) {
			try {
				api.getSites().body() ?: emptyList()
			} catch(e: Exception) {
				Log.i(TAG, "getSites Exception ${e.message}")
				emptyList()
			}
		}
	}
}
