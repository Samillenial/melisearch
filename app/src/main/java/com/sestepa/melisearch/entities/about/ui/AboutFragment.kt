package com.sestepa.melisearch.entities.about.ui

import android.os.Bundle
import android.text.method.LinkMovementMethod
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import com.sestepa.melisearch.R
import com.sestepa.melisearch.databinding.FragmentAboutBinding
import dagger.hilt.android.AndroidEntryPoint

private const val TAG = "CategoryFragment"

@AndroidEntryPoint
class AboutFragment: Fragment(R.layout.fragment_about) {

	lateinit var binding: FragmentAboutBinding

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)
		Log.i(TAG, "onViewCreated")

		binding = FragmentAboutBinding.bind(view)
		binding.linkedin.movementMethod = LinkMovementMethod.getInstance()
	}
}
