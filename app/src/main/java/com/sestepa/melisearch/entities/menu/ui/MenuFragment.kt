package com.sestepa.melisearch.entities.menu.ui

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.sestepa.melisearch.R
import com.sestepa.melisearch.databinding.FragmentMenuBinding

private const val TAG = "MenuFragment"

class MenuFragment: Fragment(R.layout.fragment_menu) {

	private lateinit var binding: FragmentMenuBinding

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)

		Log.i(TAG, "onViewCreated")
		binding = FragmentMenuBinding.bind(view)

		binding.homeButton.setOnClickListener {
			Log.i(TAG, "homeButton Clicked")
		}

		binding.searchButton.setOnClickListener {
			Log.i(TAG, "searchButton Clicked")
			Navigation.findNavController(view).navigate(R.id.productSearchFragment)
		}

		binding.historialButton.setOnClickListener {
			Log.i(TAG, "historialButton Clicked")
		}

		binding.categoriesButton.setOnClickListener {
			Log.i(TAG, "categoriesButton Clicked")
			Navigation.findNavController(view).navigate(R.id.categoryFragment)
		}

		binding.selectCountryButton.setOnClickListener {
			Log.i(TAG, "countryButton Clicked")
			Navigation.findNavController(view).navigate(R.id.siteFragment)
		}

		binding.aboutButton.setOnClickListener {
			Log.i(TAG, "aboutButton Clicked")
		}
	}
}
