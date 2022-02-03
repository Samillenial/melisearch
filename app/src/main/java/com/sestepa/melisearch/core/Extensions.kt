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
import com.squareup.picasso.Picasso
import java.security.InvalidParameterException

fun Any?.isNull() = this == null

fun Any?.isNotNull() = !isNull()

fun ImageView.load(url: String) {
	if(url.isNotEmpty())
		Glide.with(context).load(url).error(R.drawable.ic_picture).into(this)
}

fun ImageView.load2(url: String) {
	if(url.isNotEmpty())
		Picasso.get().load(url).error(R.drawable.ic_picture).into(this);
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

fun ImageView.setFlag(flagId: String) {
	val id = when(flagId) {
		"MRD" -> R.drawable.flag_costa_rica
		"MBO" -> R.drawable.flag_bolivia
		"MLC" -> R.drawable.flag_chile
		"MCO" -> R.drawable.flag_colombia
		"MCR" -> R.drawable.flag_costa_rica
		"MCU" -> R.drawable.flag_cuba
		"MEC" -> R.drawable.flag_ecuador
		"MGT" -> R.drawable.flag_guatemala
		"MHN" -> R.drawable.flag_honduras
		"MLA" -> R.drawable.flag_argentina
		"MLB" -> R.drawable.flag_brasil
		"MLM" -> R.drawable.flag_mexico
		"MLU" -> R.drawable.flag_uruguay
		"MLV" -> R.drawable.flag_venezuela
		"MNI" -> R.drawable.flag_nicaragua
		"MPA" -> R.drawable.flag_panama
		"MPY" -> R.drawable.flag_paraguay
		"MSV" -> R.drawable.flag_salvador
		"MPE" -> R.drawable.flag_peru
		else  -> throw InvalidParameterException("Wrong parameter $id")
	}
	setImageResource(id)
}

