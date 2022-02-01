package com.sestepa.melisearch.entities.category.ui

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.sestepa.melisearch.databinding.ItemCategoryBinding
import com.sestepa.melisearch.entities.category.domain.CategoryData

class CategoryViewHolder(view: View): RecyclerView.ViewHolder(view) {

	private val binding = ItemCategoryBinding.bind(view)

	fun render(category: CategoryData, onClickListener: (CategoryData) -> Unit) {
		binding.categoryName.text = category.name
		itemView.setOnClickListener { onClickListener(category) }
	}
}
