package com.sestepa.melisearch.entities.search.data.local

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ProductRecordDAO {
	companion object {

		private val productRecords = mutableListOf<ProductEntity>()

		suspend fun getRecords(): List<ProductEntity> {
			return withContext(Dispatchers.IO) {
				productRecords
			}
		}

		suspend fun saveRecord(product: ProductEntity) {
			withContext(Dispatchers.IO) {
				productRecords.add(product)
			}
		}

		suspend fun deleteRecords() {
			withContext(Dispatchers.IO) {
				productRecords.clear()
			}
		}

		suspend fun deleteRecord(product: ProductEntity) {
			withContext(Dispatchers.IO) {
				productRecords.remove(product)
			}
		}
	}
}
