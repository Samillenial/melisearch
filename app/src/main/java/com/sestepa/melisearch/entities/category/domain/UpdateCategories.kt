package com.sestepa.melisearch.entities.category.domain

import com.sestepa.melisearch.entities.category.data.CategoryRepository
import com.sestepa.melisearch.entities.site.domain.SiteData
import javax.inject.Inject

class UpdateCategories @Inject constructor(private val repository: CategoryRepository) {

	suspend operator fun invoke(site: SiteData, newCategories: List<CategoryData>) =
		repository.updateCategoriesToLocal(site, newCategories)

}
