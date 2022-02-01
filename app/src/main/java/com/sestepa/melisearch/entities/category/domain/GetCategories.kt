package com.sestepa.melisearch.entities.category.domain

import com.sestepa.melisearch.entities.category.data.CategoryRepository
import com.sestepa.melisearch.entities.site.domain.SiteData

class GetCategoriesUseCase {

	suspend operator fun invoke(site: SiteData): List<CategoryData> {
		val repository = CategoryRepository()

		return repository.getCategoriesFromLocal(site).ifEmpty {
			repository.getCategoriesFromRemote(site)
		}
	}
}
