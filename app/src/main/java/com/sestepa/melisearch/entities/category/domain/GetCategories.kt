package com.sestepa.melisearch.entities.category.domain

import com.sestepa.melisearch.entities.category.data.CategoryRepository
import com.sestepa.melisearch.entities.site.data.SiteRepository
import com.sestepa.melisearch.entities.site.domain.SiteData
import javax.inject.Inject

class GetCategories @Inject constructor(private val repository: CategoryRepository) {

	suspend operator fun invoke(site: SiteData): List<CategoryData> =
		repository.getCategoriesFromLocal(site).ifEmpty { repository.getCategoriesFromRemote(site) }
}
