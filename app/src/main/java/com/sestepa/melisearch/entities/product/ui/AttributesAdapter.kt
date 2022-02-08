package com.sestepa.melisearch.entities.product.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sestepa.melisearch.R

class AttributesAdapter(private val attributes: List<Pair<String, String>>) : RecyclerView.Adapter<AttributesViewHolder>() {

	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AttributesViewHolder =
		AttributesViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_attributes, parent, false))

	override fun onBindViewHolder(holder: AttributesViewHolder, position: Int) =
		holder.render(attributes[position])

	override fun getItemCount() = attributes.size
}
