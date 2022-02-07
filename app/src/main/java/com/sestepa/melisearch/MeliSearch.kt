package com.sestepa.melisearch

import android.app.Application
import android.util.Log
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MeliSearch: Application() {

	init {
		Log.i("MeliSearch", "Start App")
	}
}
