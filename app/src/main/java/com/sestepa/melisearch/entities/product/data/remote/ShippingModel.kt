package com.sestepa.melisearch.entities.product.data.remote

import com.google.gson.annotations.SerializedName

data class Shipping(
		@SerializedName("free_shipping") val freeShipping: Boolean = false,
						   )
