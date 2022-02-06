package com.sestepa.melisearch.entities.category.data.remote

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class CategoryRemoteService @Inject constructor(private val api: ICategoryApiClient) {

	suspend fun getCategories(siteId: String): List<CategoryModel> {
		return withContext(Dispatchers.IO) {
			api.getCategories(siteId).body() ?: emptyList()
		}
	}
}
