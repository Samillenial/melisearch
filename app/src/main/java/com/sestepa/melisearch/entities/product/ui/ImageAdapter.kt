package com.sestepa.melisearch.entities.product.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sestepa.melisearch.R

class ImageAdapter(private val images: List<String>, private val onClickListener: (String) -> Unit): RecyclerView.Adapter<ImageViewHolder>() {

	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder =
		ImageViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_images, parent, false))

	override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
		holder.render(position + 1, images.size, images[position], onClickListener)
	}

	override fun getItemCount() = images.size
}
