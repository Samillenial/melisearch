package com.sestepa.melisearch.entities.category.domain

import com.sestepa.melisearch.entities.category.data.CategoryRepository
import com.sestepa.melisearch.entities.site.domain.SiteData

class UpdateCategories {

	suspend operator fun invoke(site: SiteData, newCategories: List<CategoryData>) {
		CategoryRepository().updateCategoriesToLocal(site, newCategories)
	}
}
