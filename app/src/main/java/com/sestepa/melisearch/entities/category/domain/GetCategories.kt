package com.sestepa.melisearch.entities.category.domain

import android.util.Log
import com.sestepa.melisearch.core.PREFIX_TAG
import com.sestepa.melisearch.entities.category.data.CategoryRepository
import com.sestepa.melisearch.entities.site.domain.SiteData
import javax.inject.Inject

private const val TAG = PREFIX_TAG + "GetCategoriesUseCase"

class GetCategories @Inject constructor(private val repository: CategoryRepository) {

	suspend operator fun invoke(site: SiteData): List<CategoryData> {
		Log.i(TAG, "invoke")
		return repository.getCategoriesFromLocal(site).ifEmpty { repository.getCategoriesFromRemote(site) }
	}
}
