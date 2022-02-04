package com.sestepa.melisearch.entities.product.domain

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class ProductViewModel: ViewModel() {

	var productDetail = MutableLiveData<ProductData>()

	fun getProductDetail(productId: String) {
		viewModelScope.launch {
			val result = GetProductDetail().invoke(productId)
			productDetail.postValue(result)
		}
	}
}
