package com.sestepa.melisearch.entities.product.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sestepa.melisearch.entities.product.domain.GetProductDetail
import com.sestepa.melisearch.entities.product.domain.ProductData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductViewModel @Inject constructor(private val getProductDetailUseCase: GetProductDetail): ViewModel() {

	var productDetail = MutableLiveData<ProductData>()

	fun getProductDetail(productId: String) {
		viewModelScope.launch {
			productDetail.postValue(getProductDetailUseCase(productId))
		}
	}
}
