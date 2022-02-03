package com.sestepa.melisearch.entities.search.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sestepa.melisearch.entities.product.domain.GetItemsByCategory
import com.sestepa.melisearch.entities.product.domain.GetItemsByName
import com.sestepa.melisearch.entities.search.domain.*
import kotlinx.coroutines.launch

class SearchViewModel: ViewModel() {

	var paging = PagingData(limit = 50)
	var textQuery = MutableLiveData<String>()

	var searchResult = MutableLiveData<SearchData>()
	var currentProduct = MutableLiveData<ProductData>()

	fun getItemsByName(siteId: String) {
		viewModelScope.launch {
			val result = GetItemsByName()(siteId, textQuery.value!!, paging)

			if(result.isNotEmpty()) {
				searchResult.postValue(result)
			}
		}
	}

	fun getItemsByCategory(siteId: String, categoryId: String) {
		viewModelScope.launch {
			val result = GetItemsByCategory()(siteId, categoryId, paging)
			searchResult.postValue(result)
		}
	}

	fun saveProductRecord() {
		viewModelScope.launch {
			SaveProductRecord()(currentProduct.value!!)
		}
	}

	fun getSearchRecord() {
		viewModelScope.launch {
			val result = GetSearchRecord()()
			searchResult.postValue(result)
		}
	}
}
