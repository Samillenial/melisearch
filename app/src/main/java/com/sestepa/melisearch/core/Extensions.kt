package com.sestepa.melisearch.core

import android.app.Activity
import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.ImageView
import android.widget.Toast
import androidx.annotation.ColorRes
import androidx.appcompat.widget.SearchView
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.sestepa.melisearch.R

fun Any?.isNull() = this == null

fun Any?.isNotNull() = !isNull()

fun ImageView.load(url: String) {
	if(url.isNotEmpty())
		Glide.with(context).load(url).error(R.drawable.ic_picture).into(this)
}

fun Context.hideKeyboard(view: View) {
	val inputMethodManager = getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
	inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
}

fun Context.color(@ColorRes color: Int) = ContextCompat.getColor(this, color)

fun Context.showToast(text: String, duration: Int = Toast.LENGTH_SHORT) = Toast.makeText(this, text, duration).show()

fun SearchView.onQuerySummit(listener: (String) -> Boolean) {
	this.setOnQueryTextListener(object: SearchView.OnQueryTextListener {

		override fun onQueryTextSubmit(query: String?) = listener(query!!)

		override fun onQueryTextChange(newText: String?): Boolean = true
	})
}
