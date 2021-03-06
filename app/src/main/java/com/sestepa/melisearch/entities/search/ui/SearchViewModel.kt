package com.sestepa.melisearch.entities.search.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sestepa.melisearch.entities.product.domain.ProductData
import com.sestepa.melisearch.entities.search.domain.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
		private val getItemsByNameUseCase: GetItemsByName,
		private val getItemsByCategoryUseCase: GetItemsByCategory,
		private val saveItemRecordUseCase: SaveItemRecord,
		private val getSearchRecordUseCase: GetSearchRecord
										 ): ViewModel() {

	var paging = PagingData(limit = 50)
	var textQuery = MutableLiveData<String>()

	var searchResult = MutableLiveData<SearchData>()
	var currentItem = MutableLiveData<ProductData>()

	fun getItemsByName(siteId: String) {
		viewModelScope.launch {

			textQuery.value?.let {
				searchResult.postValue(getItemsByNameUseCase(siteId, it, paging))
			}
		}
	}

	fun getItemsByCategory(siteId: String, categoryId: String) {
		viewModelScope.launch {
			searchResult.postValue(getItemsByCategoryUseCase(siteId, categoryId, paging))
		}
	}

	fun saveItemRecord() {
		viewModelScope.launch {
			currentItem.value?.let {
				saveItemRecordUseCase(it)
			}
		}
	}

	fun getSearchRecord() {
		viewModelScope.launch {
			searchResult.postValue(getSearchRecordUseCase())
		}
	}
}
