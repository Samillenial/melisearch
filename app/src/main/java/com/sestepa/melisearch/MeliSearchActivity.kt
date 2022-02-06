package com.sestepa.melisearch

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.sestepa.melisearch.databinding.ActivityMelisearchBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MeliSearchActivity: AppCompatActivity() {

	private lateinit var binding: ActivityMelisearchBinding

	init {
		Log.i("MeliSearchActivity", "Start Activity")
	}

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		binding = ActivityMelisearchBinding.inflate(layoutInflater)
		setContentView(binding.root)
	}
}
