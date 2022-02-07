package com.sestepa.melisearch.entities.category.data.remote

import android.util.Log
import com.sestepa.melisearch.core.PREFIX_TAG
import kotlinx.coroutines.withContext
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

private const val TAG = PREFIX_TAG + "CategoryRemoteService"

class CategoryRemoteService @Inject constructor(private val dispatcher: CoroutineContext, private val api: ICategoryApiClient) {

	suspend fun getCategories(siteId: String): List<CategoryModel> {
		Log.i(TAG, "getCategories")
		return withContext(dispatcher) {
			try {
				api.getCategories(siteId).body() ?: emptyList()
			} catch(e: Exception) {
				Log.e(TAG, "getCategories Exception: ${e.message}")
				emptyList()
			}
		}
	}
}
