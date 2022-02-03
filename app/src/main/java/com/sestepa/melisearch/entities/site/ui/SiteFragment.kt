package com.sestepa.melisearch.entities.site.ui

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.sestepa.melisearch.R
import com.sestepa.melisearch.core.showToast
import com.sestepa.melisearch.databinding.FragmentSiteBinding
import com.sestepa.melisearch.entities.site.domain.SiteData

private const val TAG = "SiteFragment"

class SiteFragment: Fragment(R.layout.fragment_site) {

	private lateinit var binding: FragmentSiteBinding
	private val viewModel: SiteViewModel by viewModels()

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)

		Log.i(TAG, "onViewCreated")
		binding = FragmentSiteBinding.bind(view)

		viewModel.getSites()

		viewModel.siteList.observe(viewLifecycleOwner) { list ->
			list.forEach { item -> Log.i(TAG, "SITE: $item") }
			initRecyclerView()
		}

		viewModel.currentSite.observe(viewLifecycleOwner){
			Log.i(TAG, "Update CurrentSite")
			viewModel.updateCurrentSite()

			Log.i(TAG, "Get Categories")
			viewModel.getCategories()
		}

		viewModel.categoriesList.observe(viewLifecycleOwner) { list ->
			Log.i(TAG, "Download sites")
			list.forEach { Log.i(TAG, "CATEGORY: $it") }

			viewModel.updateCategories()
			Navigation.findNavController(view).navigate(SiteFragmentDirections.actionSiteFragmentToMenuFragment(viewModel.currentSite.value!!))
		}
	}

	private fun onItemSelected(site: SiteData) {
		Log.i(TAG, "Country Selected: ${site.name}")
		context?.showToast(site.name)
		viewModel.currentSite.postValue(site)
	}

	private fun initRecyclerView() {
		binding.countryRecyclerView.layoutManager = LinearLayoutManager(context)
		binding.countryRecyclerView.adapter = SiteAdapter(viewModel.siteList.value ?: listOf()) { site ->
			onItemSelected(site)
		}
	}
}

