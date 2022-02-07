package com.sestepa.melisearch.entities.site.domain

import android.util.Log
import com.sestepa.melisearch.core.PREFIX_TAG
import com.sestepa.melisearch.entities.site.data.SiteRepository
import javax.inject.Inject

private const val TAG = PREFIX_TAG + "GetCurrentSiteUseCase"

class GetCurrentSite @Inject constructor(private val repository: SiteRepository) {

	suspend operator fun invoke(): SiteData {
		Log.i(TAG, "invoke")
		return repository.getCurrentSiteToLocal()
	}
}
