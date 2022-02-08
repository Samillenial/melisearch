package com.sestepa.melisearch.entities.product.ui

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.sestepa.melisearch.core.load
import com.sestepa.melisearch.databinding.ItemImagesBinding

class ImageViewHolder(view: View): RecyclerView.ViewHolder(view) {

	private val binding = ItemImagesBinding.bind(view)

	fun render(actual: Int, total: Int, url: String, onClickListener: (String) -> Unit) {
		binding.counter.text = String.format("$actual/$total")
		binding.imageView.load(url)
		itemView.setOnClickListener { onClickListener(url) }
	}
}
