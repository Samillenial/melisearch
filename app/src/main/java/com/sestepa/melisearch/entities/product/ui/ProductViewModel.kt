package com.sestepa.melisearch.entities.product.ui

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sestepa.melisearch.core.PREFIX_TAG
import com.sestepa.melisearch.entities.product.domain.GetProductDetail
import com.sestepa.melisearch.entities.product.domain.ProductData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

private const val TAG = PREFIX_TAG + "ProductViewModel"

@HiltViewModel
class ProductViewModel @Inject constructor(private val getProductDetailUseCase: GetProductDetail): ViewModel() {

	var productDetail = MutableLiveData<ProductData>()
	var currentImage = MutableLiveData<String>()

	fun getProductDetail(productId: String) {
		viewModelScope.launch {
			Log.i(TAG, "getProductDetail")
			productDetail.postValue(getProductDetailUseCase(productId))
		}
	}
}
