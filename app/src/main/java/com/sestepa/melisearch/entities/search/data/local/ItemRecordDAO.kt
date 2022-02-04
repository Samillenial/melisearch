package com.sestepa.melisearch.entities.search.data.local

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ItemRecordDAO {
	companion object {

		private val itemsRecord = mutableListOf<ItemEntity>()

		suspend fun getRecords(): List<ItemEntity> {
			return withContext(Dispatchers.IO) {
				itemsRecord
			}
		}

		suspend fun saveRecord(item: ItemEntity) {
			withContext(Dispatchers.IO) {
				itemsRecord.add(item)
			}
		}

		suspend fun deleteRecords() {
			withContext(Dispatchers.IO) {
				itemsRecord.clear()
			}
		}

		suspend fun deleteRecord(item: ItemEntity) {
			withContext(Dispatchers.IO) {
				itemsRecord.remove(item)
			}
		}
	}
}
