package com.sestepa.melisearch.entities.product.domain

import com.sestepa.melisearch.entities.product.data.ProductRepository

class GetProductQuery {

	suspend operator fun invoke(siteId: String, query: String, paging: PagingData): List<ProductData> {
		val repository = ProductRepository()

		return repository.getProductQueryFromRemote(siteId, query, paging)
	}
}
