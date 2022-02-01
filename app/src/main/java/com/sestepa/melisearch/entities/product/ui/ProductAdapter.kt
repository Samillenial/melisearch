package com.sestepa.melisearch.entities.product.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sestepa.melisearch.R
import com.sestepa.melisearch.entities.product.domain.ProductData

class ProductAdapter(private val productsResult: List<ProductData>, private val onClickListener: (ProductData) -> Unit): RecyclerView.Adapter<ProductViewHolder>() {

	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ProductViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_product, parent, false))

	override fun onBindViewHolder(holder: ProductViewHolder, position: Int) = holder.render(productsResult[position], onClickListener)

	override fun getItemCount() = productsResult.size
}
