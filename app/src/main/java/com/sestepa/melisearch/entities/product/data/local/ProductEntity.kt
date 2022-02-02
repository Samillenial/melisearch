package com.sestepa.melisearch.entities.product.data.local

import com.sestepa.melisearch.entities.product.domain.ProductData

data class ProductEntity(var id: String = "", var title: String = "", var price: String = "", var image: String = "", var freeShipping: Boolean = false, var rate: Float = 0F)

fun ProductData.toProductModel() = ProductEntity(id, title, price, image, freeShipping, rate)

fun ProductEntity.toProductData() = ProductData( id, title, price, image, freeShipping, rate)
