package com.sestepa.melisearch.entities.search.data.local

import com.sestepa.melisearch.entities.search.domain.ItemData

data class ItemEntity(var id: String = "", var title: String = "", var price: String = "", var image: String = "", var freeShipping: Boolean = false, var rate: Float = 0F)

fun ItemData.toItemEntity() = ItemEntity(id, title, price, image, freeShipping, rate)

fun ItemEntity.toItemData() = ItemData(id, title, price, image, freeShipping, rate)
