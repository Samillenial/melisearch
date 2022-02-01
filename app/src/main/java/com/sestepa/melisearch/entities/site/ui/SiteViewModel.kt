package com.sestepa.melisearch.entities.site.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sestepa.melisearch.core.isNotNull
import com.sestepa.melisearch.entities.category.domain.CategoryData
import com.sestepa.melisearch.entities.category.domain.GetCategoriesUseCase
import com.sestepa.melisearch.entities.category.domain.UpdateCategories
import com.sestepa.melisearch.entities.site.domain.*
import kotlinx.coroutines.launch

class SiteViewModel: ViewModel() {

	var siteList = MutableLiveData<List<SiteData>>()
	var currentSite = MutableLiveData<SiteData>()

	val categoriesList = MutableLiveData<List<CategoryData>>()
	val currentCategory = MutableLiveData<CategoryData>()

	fun getSites(){
		viewModelScope.launch {
			val result = GetSitesUseCase()()

			if( result.isNotEmpty() ) {
				siteList.postValue(result.sorted())
			}
		}
	}

	fun updateSites(){
		viewModelScope.launch{
			if( siteList.value.isNotNull())
				UpdateSitesUseCase()(siteList.value!!)
		}
	}

	fun getCurrentSite(){
		viewModelScope.launch {
			currentSite.postValue(GetCurrentSite()()!!)
		}
	}

	fun updateCurrentSite() {
		viewModelScope.launch {
			if(currentSite.value.isNotNull())
				UpdateCurrentSiteUseCase()(currentSite.value!!)
		}
	}

	fun getCategories(){
		viewModelScope.launch {
			val result = GetCategoriesUseCase()(currentSite.value!!)

			if(result.isNotEmpty()) {
				categoriesList.postValue(result.sorted())
			}
		}
	}

	fun updateCategories() {
		viewModelScope.launch {
			if(currentSite.value.isNotNull() && siteList.value.isNotNull())
				UpdateCategories().invoke(currentSite.value!!, categoriesList.value!!)
		}
	}
}
