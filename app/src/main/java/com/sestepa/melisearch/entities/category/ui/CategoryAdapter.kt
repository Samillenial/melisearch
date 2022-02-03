package com.sestepa.melisearch.entities.category.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sestepa.melisearch.R
import com.sestepa.melisearch.entities.category.domain.CategoryData

class CategoryAdapter(private val categoryDataList: List<CategoryData>, private val onClickListener: (CategoryData) -> Unit): RecyclerView.Adapter<CategoryViewHolder>() {

	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
		CategoryViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_category, parent, false))

	override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) = holder.render(categoryDataList[position], onClickListener)

	override fun getItemCount() = categoryDataList.size
}
