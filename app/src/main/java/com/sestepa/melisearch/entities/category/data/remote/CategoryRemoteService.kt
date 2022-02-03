package com.sestepa.melisearch.entities.category.data.remote

import com.sestepa.melisearch.core.MELI_URL_BASE
import com.sestepa.melisearch.core.RetrofitProvider
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class CategoryRemoteService {

	private val retrofit = RetrofitProvider(MELI_URL_BASE).create()

	suspend fun getCategories(siteId: String): List<CategoryModel> {
		return withContext(Dispatchers.IO) {
			val response = retrofit.create(ICategoryApiClient::class.java).getCategories(siteId)
			response.body() ?: emptyList()
		}
	}
}
