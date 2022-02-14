package com.sestepa.melisearch.entities.site.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sestepa.melisearch.core.isNotNull
import com.sestepa.melisearch.entities.category.domain.CategoryData
import com.sestepa.melisearch.entities.category.domain.GetCategories
import com.sestepa.melisearch.entities.category.domain.UpdateCategories
import com.sestepa.melisearch.entities.site.domain.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SiteViewModel @Inject constructor(
		private val getSitesUseCase: GetSites,
		private val updateSitesUseCase: UpdateSites,
		private val getCurrentSiteUseCase: GetCurrentSite,
		private val updateCurrentSiteUseCase: UpdateCurrentSite,
		private val getCategoriesUseCase: GetCategories,
		private val updateCategoriesUseCase: UpdateCategories
									   ): ViewModel() {

	var siteList = MutableLiveData<List<SiteData>>()
	var currentSite = MutableLiveData<SiteData>()

	val categoriesList = MutableLiveData<List<CategoryData>>()
	val currentCategory = MutableLiveData<CategoryData>()

	fun getSites() {
		viewModelScope.launch {
			siteList.postValue(getSitesUseCase().sorted())
		}
	}

	fun updateSites() {
		viewModelScope.launch {
			siteList.value?.let {
				updateSitesUseCase(it)
			}
		}
	}

	fun getCurrentSite() {
		viewModelScope.launch {
			currentSite.postValue(getCurrentSiteUseCase())
		}
	}

	fun updateCurrentSite() {
		viewModelScope.launch {

			currentSite.value?.let {
				updateCurrentSiteUseCase(it)
			}
		}
	}

	fun getCategories() {
		viewModelScope.launch {

			currentSite.value?.let {
				categoriesList.postValue(getCategoriesUseCase(it).sorted())
			}
		}
	}

	fun updateCategories() {
		viewModelScope.launch {
			if(currentSite.value.isNotNull() && siteList.value.isNotNull())
				updateCategoriesUseCase(currentSite.value!!, categoriesList.value!!)
		}
	}
}
