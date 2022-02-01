package com.sestepa.melisearch.core

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitProvider( private val url: String ) {

		fun create(): Retrofit = Retrofit.Builder()
				.baseUrl(url)
				.addConverterFactory(GsonConverterFactory.create())
				.build()
}

