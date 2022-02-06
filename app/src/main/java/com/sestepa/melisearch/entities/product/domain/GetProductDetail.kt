package com.sestepa.melisearch.entities.product.domain

import com.sestepa.melisearch.entities.product.data.ProductRepository
import javax.inject.Inject

class GetProductDetail @Inject constructor(private val repository: ProductRepository) {

	suspend operator fun invoke(productId: String) =
		repository.getProductDetail(productId)
}
