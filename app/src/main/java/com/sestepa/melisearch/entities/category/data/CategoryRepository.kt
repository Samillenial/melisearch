package com.sestepa.melisearch.entities.category.data

import android.util.Log
import com.sestepa.melisearch.core.PREFIX_TAG
import com.sestepa.melisearch.entities.category.data.local.CategoryDb
import com.sestepa.melisearch.entities.category.data.local.toCategoryEntity
import com.sestepa.melisearch.entities.category.data.remote.CategoryRemoteService
import com.sestepa.melisearch.entities.category.domain.CategoryData
import com.sestepa.melisearch.entities.site.domain.SiteData
import javax.inject.Inject

private const val TAG = PREFIX_TAG + "CategoryRepository"

class CategoryRepository @Inject constructor(private val remoteService: CategoryRemoteService, private val localDb: CategoryDb) {

	suspend fun getCategoriesFromRemote(site: SiteData): List<CategoryData> {
		Log.i(TAG, "getCategoriesFromRemote")
		return remoteService.getCategories(site.id).map { model -> model.toCategoryData() }
	}

	suspend fun getCategoriesFromLocal(site: SiteData): List<CategoryData> {
		Log.i(TAG, "getCategoriesFromLocal")
		return localDb.getCategories(site).map { entity -> entity.toCategoryData() }
	}

	suspend fun updateCategoriesToLocal(site: SiteData, newCategories: List<CategoryData>) {
		Log.i(TAG, "updateCategoriesToLocal")
		localDb.updateCategoriesToLocal(site, newCategories.map { data -> data.toCategoryEntity() })
	}
}
