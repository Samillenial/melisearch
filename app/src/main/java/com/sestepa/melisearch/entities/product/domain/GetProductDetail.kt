package com.sestepa.melisearch.entities.product.domain

import com.sestepa.melisearch.entities.product.data.ProductRepository

class GetProductDetail {

	suspend operator fun invoke(productId: String) =
		ProductRepository().getProductDetail(productId)
}
