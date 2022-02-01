package com.sestepa.melisearch.entities.category.data

import com.sestepa.melisearch.entities.category.data.local.CategoriesProvider
import com.sestepa.melisearch.entities.category.data.local.toCategoryEntity
import com.sestepa.melisearch.entities.category.data.remote.CategoryRemoteService
import com.sestepa.melisearch.entities.category.domain.CategoryData
import com.sestepa.melisearch.entities.site.domain.SiteData

class CategoryRepository {

	suspend fun getCategoriesFromRemote(site: SiteData): List<CategoryData> = CategoryRemoteService().getCategories(site).map { model -> model.toCategoryData() }

	suspend fun getCategoriesFromLocal(site: SiteData): List<CategoryData> = CategoriesProvider.getCategories(site).map { entity -> entity.toCategoryData() }

	suspend fun updateCategoriesToLocal( site: SiteData, newCategories: List<CategoryData>) = CategoriesProvider.updateCategoriesToLocal(site, newCategories.map { data -> data.toCategoryEntity()})
}
