package com.sestepa.melisearch.entities.search.ui

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.sestepa.melisearch.core.load
import com.sestepa.melisearch.databinding.ItemProductBinding
import com.sestepa.melisearch.entities.search.domain.ItemData

class SearchViewHolder(view: View): RecyclerView.ViewHolder(view) {

	private val binding = ItemProductBinding.bind(view)

	fun render(product: ItemData, onClickListener: (ItemData) -> Unit) {
		binding.title.text = product.title
		binding.image.load(product.image)

		if(product.freeShipping)
			binding.freeShipping.visibility = View.VISIBLE

		binding.price.text = product.price
		binding.ratingBar.rating = product.rate

		itemView.setOnClickListener { onClickListener(product) }
	}
}
