package com.sestepa.melisearch.entities.category.data.local

import com.sestepa.melisearch.entities.site.domain.SiteData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class CategoriesProvider {

	companion object {

		private var categories: List<CategoryEntity> = emptyList()
		private var actualSite: SiteData = SiteData("", "", "")

		suspend fun getCategories(site: SiteData): List<CategoryEntity> {
			return withContext(Dispatchers.IO) {
				if(actualSite == site) categories else emptyList()
			}
		}

		suspend fun updateCategoriesToLocal(site: SiteData, newCategories: List<CategoryEntity>) {
			withContext(Dispatchers.IO) {
				actualSite = site
				categories = newCategories
			}
		}
	}
}

