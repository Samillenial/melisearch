package com.sestepa.melisearch.core

import com.sestepa.melisearch.entities.category.data.remote.ICategoryApiClient
import com.sestepa.melisearch.entities.product.data.remote.IProductApiClient
import com.sestepa.melisearch.entities.search.data.remote.ISearchApiClient
import com.sestepa.melisearch.entities.site.data.remote.ISiteApiClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

const val MELI_URL_BASE = "https://api.mercadolibre.com"

@Module
@InstallIn(SingletonComponent::class)
class MeliEndPointProvider {

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

	@Provides
	//@Singleton
	fun provideRetrofit(): Retrofit =
		Retrofit.Builder()
				.client(httpClient)
				.baseUrl(MELI_URL_BASE)
				.addConverterFactory(GsonConverterFactory.create())
				.build()

	@Provides
	@Singleton
	fun provideSiteApiClient(retrofit: Retrofit): ISiteApiClient =
		retrofit.create(ISiteApiClient::class.java)

	@Provides
	@Singleton
	fun provideCategoryApiClient(retrofit: Retrofit): ICategoryApiClient =
		retrofit.create(ICategoryApiClient::class.java)

	@Provides
	@Singleton
	fun provideProductApiClient(retrofit: Retrofit): IProductApiClient =
		retrofit.create(IProductApiClient::class.java)

	@Provides
	@Singleton
	fun provideSearchApiClient(retrofit: Retrofit): ISearchApiClient =
		retrofit.create(ISearchApiClient::class.java)
}
