package com.sestepa.melisearch.entities.menu.ui

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.sestepa.melisearch.R
import com.sestepa.melisearch.core.setFlag
import com.sestepa.melisearch.databinding.FragmentMenuBinding

private const val TAG = "MenuFragment"

class MenuFragment: Fragment(R.layout.fragment_menu) {

	private lateinit var binding: FragmentMenuBinding
	private val args: MenuFragmentArgs by navArgs()

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)

		Log.i(TAG, "onViewCreated")
		binding = FragmentMenuBinding.bind(view)

		setCountryFlag(args.site.id)

		binding.homeButton.setOnClickListener {
			Log.i(TAG, "homeButton Clicked")
		}

		binding.searchButton.setOnClickListener {
			Log.i(TAG, "searchButton Clicked")

			Navigation.findNavController(view).navigate(MenuFragmentDirections.actionMenuFragmentToSearchByNameFragment(args.site))
		}

		binding.recordButton.setOnClickListener {
			Log.i(TAG, "recordButton Clicked")
			Navigation.findNavController(view).navigate(MenuFragmentDirections.actionMenuFragmentToRecordFragment())
		}

		binding.categoriesButton.setOnClickListener {
			Log.i(TAG, "categoriesButton Clicked")
			Navigation.findNavController(view).navigate(MenuFragmentDirections.actionMenuFragmentToCategoryFragment())
		}

		binding.selectCountryButton.setOnClickListener {
			Log.i(TAG, "countryButton Clicked")
			Navigation.findNavController(view).navigate(MenuFragmentDirections.actionMenuFragmentToSiteFragment())
		}

		binding.aboutButton.setOnClickListener {
			Navigation.findNavController(view).navigate(MenuFragmentDirections.actionMenuFragmentToAboutFragment())
			Log.i(TAG, "aboutButton Clicked")
		}
	}

	private fun setCountryFlag(id: String) = binding.countryFlag.setFlag(id)
}
