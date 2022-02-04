package com.sestepa.melisearch.entities.welcome.ui

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.sestepa.melisearch.R
import com.sestepa.melisearch.core.showToast
import com.sestepa.melisearch.entities.site.ui.SiteViewModel

private const val TAG = "WelcomeFragment"

class WelcomeFragment: Fragment(R.layout.fragment_welcome) {

	private val viewModel: SiteViewModel by viewModels()

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		viewModel.getSites()

		viewModel.siteList.observe(viewLifecycleOwner) { sites ->

			if(sites.isEmpty()) {
				Log.e(TAG, "Download SITES fail")

				requireContext().showToast(getString(R.string.try_again))
				requireActivity().onBackPressed()
			}
			else {
				Log.i(TAG, "Download SITES sucessful !!!")
				sites.forEach { site -> Log.i(TAG, "SITE: $site") }

				viewModel.updateSites()
				Navigation.findNavController(view).navigate(R.id.siteFragment)
			}
		}
	}
}
