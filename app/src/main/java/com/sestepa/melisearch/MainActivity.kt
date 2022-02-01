package com.sestepa.melisearch

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.sestepa.melisearch.databinding.ActivityMainBinding

class ActivityMainBinding: AppCompatActivity() {

	private lateinit var binding: ActivityMainBinding

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		binding = ActivityMainBinding.inflate(layoutInflater)
		setContentView(binding.root)
	}
}
