package com.sestepa.melisearch.entities.product.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sestepa.melisearch.entities.product.domain.GetProductQuery
import com.sestepa.melisearch.entities.product.domain.PagingData
import com.sestepa.melisearch.entities.product.domain.ProductData
import kotlinx.coroutines.launch

class ProductViewModel: ViewModel() {

	var siteId = "MLC"
	var paging = PagingData(limit = 50)
	var textQuery = MutableLiveData<String>()
	var productQueryResult = MutableLiveData<List<ProductData>>()
	var currentProduct = MutableLiveData<ProductData>()

	fun getProductQuery(){
		viewModelScope.launch {
			val result = GetProductQuery()(siteId, textQuery.value!!, paging)

			if(result.isNotEmpty()) {
				productQueryResult.postValue(result.products)
			}
		}
	}
}
