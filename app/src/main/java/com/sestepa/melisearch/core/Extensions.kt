package com.sestepa.melisearch.core

import android.content.Context
import android.widget.ImageView
import android.widget.Toast
import androidx.annotation.ColorRes
import androidx.appcompat.widget.SearchView
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide

fun Any?.isNull() = this == null

fun Any?.isNotNull() = !isNull()

fun ImageView.load(url: String) {
	if(url.isNotEmpty())
		Glide.with(context).load(url).into(this)
}

fun Context.color(@ColorRes color: Int) = ContextCompat.getColor(this, color)

fun Context.showToast(text: String, duration: Int = Toast.LENGTH_SHORT) = Toast.makeText(this, text, duration).show()

fun SearchView.onQuerySummit(listener: (String) -> Boolean) {
	this.setOnQueryTextListener(object: SearchView.OnQueryTextListener {

		override fun onQueryTextSubmit(query: String?) = listener(query!!)

		override fun onQueryTextChange(newText: String?): Boolean = true
	})
}
