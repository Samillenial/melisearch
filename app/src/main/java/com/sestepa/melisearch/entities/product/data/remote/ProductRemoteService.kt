package com.sestepa.melisearch.entities.product.data.remote

import android.util.Log
import com.sestepa.melisearch.core.MELI_URL_BASE
import com.sestepa.melisearch.core.RetrofitProvider
import com.sestepa.melisearch.core.isNotNull
import com.sestepa.melisearch.entities.product.domain.PagingData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ProductRemoteService {

	private val retrofit = RetrofitProvider(MELI_URL_BASE).create()

	suspend fun getProductQuery(siteId: String, query: String, paging: PagingData): QueryResultModel  {
		return withContext(Dispatchers.IO) {
			val response = retrofit.create(IProductApiClient::class.java).getProductQuery(siteId, query, paging.offset, paging.limit)

			response.body() ?: QueryResultModel( )
		}
	}
}
