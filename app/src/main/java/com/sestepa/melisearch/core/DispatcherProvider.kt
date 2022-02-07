package com.sestepa.melisearch.core

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.Dispatchers
import javax.inject.Singleton
import kotlin.coroutines.CoroutineContext

@Module
@InstallIn(SingletonComponent::class)

class DispatcherProvider {

	@Provides
	@Singleton
	fun provideIODispatcher(): CoroutineContext = Dispatchers.IO
}
