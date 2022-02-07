package com.sestepa.melisearch.entities.search.data.local

import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton
import kotlin.coroutines.CoroutineContext

@Singleton
class ItemRecordDb @Inject constructor(private val dispatcher: CoroutineContext) {

	private val itemsRecord = mutableListOf<ItemEntity>()

	suspend fun getRecords(): List<ItemEntity> {
		return withContext(dispatcher) {
			itemsRecord
		}
	}

	suspend fun saveRecord(item: ItemEntity) {
		withContext(dispatcher) {
			itemsRecord.add(item)
		}
	}

	suspend fun deleteRecords() {
		withContext(dispatcher) {
			itemsRecord.clear()
		}
	}

	suspend fun deleteRecord(item: ItemEntity) {
		withContext(dispatcher) {
			itemsRecord.remove(item)
		}
	}
}
