package com.sestepa.melisearch.entities.product.data.remote

import android.util.Log
import com.sestepa.melisearch.core.PREFIX_TAG
import kotlinx.coroutines.withContext
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

private const val TAG = PREFIX_TAG + "ProductRemoteService"

class ProductRemoteService @Inject constructor(private val dispatcher: CoroutineContext, private val api: IProductApiClient) {

	suspend fun getProductDetail(productId: String): ProductModel {
		Log.i(TAG, "getProductDetail")
		return withContext(dispatcher) {
			try {
				api.getProductDetails(productId).body() ?: ProductModel()
			} catch(e: Exception) {
				Log.e(TAG, "getProductDetail Exception ${e.message}")
				ProductModel()
			}
		}
	}
}
