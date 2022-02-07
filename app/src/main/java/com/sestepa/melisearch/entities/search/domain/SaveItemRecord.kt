package com.sestepa.melisearch.entities.search.domain

import android.util.Log
import com.sestepa.melisearch.core.PREFIX_TAG
import com.sestepa.melisearch.entities.product.domain.ProductData
import com.sestepa.melisearch.entities.search.data.SearchRepository
import javax.inject.Inject

private const val TAG = PREFIX_TAG + "SaveItemRecord"

class SaveItemRecord @Inject constructor(private val repository: SearchRepository) {

	suspend operator fun invoke(item: ProductData) {
		Log.i(TAG, "invoke")
		repository.saveItemRecordToLocal(item)
	}
}
