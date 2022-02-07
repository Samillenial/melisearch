package com.sestepa.melisearch.entities.site.ui

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.sestepa.melisearch.R
import com.sestepa.melisearch.core.PREFIX_TAG
import com.sestepa.melisearch.core.showToast
import com.sestepa.melisearch.databinding.FragmentSiteBinding
import com.sestepa.melisearch.entities.site.domain.SiteData
import dagger.hilt.android.AndroidEntryPoint

private const val TAG = PREFIX_TAG + "SiteFragment"

@AndroidEntryPoint
class SiteFragment: Fragment(R.layout.fragment_site) {

	private lateinit var binding: FragmentSiteBinding
	private val viewModel: SiteViewModel by viewModels()

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)

		Log.i(TAG, "onViewCreated")
		binding = FragmentSiteBinding.bind(view)

		viewModel.getSites()
		viewModel.siteList.observe(viewLifecycleOwner) { sites ->

			if(sites.isEmpty()) {
				Log.e(TAG, "sites is empty")

				requireContext().showToast(getString(R.string.try_again))
				requireActivity().onBackPressed()
			} else {
				Log.i(TAG, "Get SITES successful !!!")
				sites.forEach { site -> Log.i(TAG, "SITE: $site") }
				configRecyclerView()
			}
		}

		viewModel.currentSite.observe(viewLifecycleOwner) { site ->
			Log.i(TAG, "Try Update Current Site ${site.name}")
			viewModel.updateCurrentSite()

			Log.i(TAG, "Try Get Categories")
			viewModel.getCategories()
		}

		viewModel.categoriesList.observe(viewLifecycleOwner) { categories ->

			if(categories.isEmpty()) {
				Log.e(TAG, "Download CATEGORY fail")

				requireContext().showToast(getString(R.string.try_again))
				requireActivity().onBackPressed()
			} else {
				Log.i(TAG, "Download CATEGORY successful !!!")
				categories.forEach { Log.i(TAG, "CATEGORY: $it") }

				viewModel.updateCategories()
				Navigation.findNavController(view).navigate(SiteFragmentDirections.actionSiteFragmentToMenuFragment(viewModel.currentSite.value!!))
			}
		}
	}

	private fun onItemSelected(site: SiteData) {
		Log.i(TAG, "Country Selected: ${site.name}")
		requireContext().showToast(site.name)
		viewModel.currentSite.postValue(site)
	}

	private fun configRecyclerView() {
		binding.countryRecycler.layoutManager = LinearLayoutManager(context)
		binding.countryRecycler.adapter = SiteAdapter(viewModel.siteList.value ?: listOf()) { site ->
			onItemSelected(site)
		}
	}
}
