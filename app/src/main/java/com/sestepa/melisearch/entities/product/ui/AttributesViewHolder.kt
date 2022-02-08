package com.sestepa.melisearch.entities.product.ui

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.sestepa.melisearch.databinding.ItemAttributesBinding


class AttributesViewHolder(view: View): RecyclerView.ViewHolder(view) {

	private val binding = ItemAttributesBinding.bind(view)

	fun render(pair: Pair<String, String>) {
		binding.name.text = pair.first
		binding.value.text = pair.second
	}
}
