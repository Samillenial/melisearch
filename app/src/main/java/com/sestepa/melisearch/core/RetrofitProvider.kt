package com.sestepa.melisearch.core

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class RetrofitProvider(private val url: String) {

	private val httpClient: OkHttpClient
		get() {
			return OkHttpClient.Builder()
					.addInterceptor(HttpLoggingInterceptor().apply {
						level = HttpLoggingInterceptor.Level.BODY
					})
					.addInterceptor(HttpLoggingInterceptor().apply {
						level = HttpLoggingInterceptor.Level.HEADERS
					}).build()
		}

	fun create(): Retrofit = Retrofit.Builder()
			.client(httpClient)
			.baseUrl(url)
			.addConverterFactory(GsonConverterFactory.create())
			.build()
}

