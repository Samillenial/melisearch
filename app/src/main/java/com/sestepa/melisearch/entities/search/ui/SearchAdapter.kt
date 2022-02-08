package com.sestepa.melisearch.entities.search.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sestepa.melisearch.R
import com.sestepa.melisearch.entities.product.domain.ProductData
import com.sestepa.melisearch.entities.search.domain.SearchData

class SearchAdapter(private val result: SearchData, private val onClickListener: (ProductData) -> Unit): RecyclerView.Adapter<SearchViewHolder>() {

	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
		SearchViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_product, parent, false))

	override fun onBindViewHolder(holder: SearchViewHolder, position: Int) =
		holder.render(result.items[position], onClickListener)

	override fun getItemCount() = result.items.size
}
