package com.sestepa.melisearch.entities.category.data.local

import android.util.Log
import com.sestepa.melisearch.core.PREFIX_TAG
import com.sestepa.melisearch.entities.site.domain.SiteData
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton
import kotlin.coroutines.CoroutineContext

private const val TAG = PREFIX_TAG + "CategoryDb"

@Singleton
class CategoryDb @Inject constructor(private val dispatcher: CoroutineContext) {

	private var categories: List<CategoryEntity> = emptyList()
	private var actualSite: SiteData = SiteData()

	suspend fun getCategories(site: SiteData): List<CategoryEntity> {
		Log.i(TAG, "getCategories")
		return withContext(dispatcher) {
			if(actualSite == site) categories else emptyList()
		}
	}

	suspend fun updateCategoriesToLocal(site: SiteData, newCategories: List<CategoryEntity>) {
		Log.i(TAG, "updateCategoriesToLocal")
		withContext(dispatcher) {
			actualSite = site
			categories = newCategories
		}
	}
}

