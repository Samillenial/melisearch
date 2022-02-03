package com.sestepa.melisearch.entities.category.ui

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.sestepa.melisearch.R
import com.sestepa.melisearch.core.showToast
import com.sestepa.melisearch.databinding.FragmentCategoryBinding
import com.sestepa.melisearch.entities.category.domain.CategoryData
import com.sestepa.melisearch.entities.site.ui.SiteViewModel

private const val TAG = "CategoryFragment"

class CategoryFragment: Fragment(R.layout.fragment_category) {

	private lateinit var binding: FragmentCategoryBinding
	private val viewModel: SiteViewModel by viewModels()

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)

		Log.i(TAG, "onViewCreated")
		binding = FragmentCategoryBinding.bind(view)

		viewModel.getCurrentSite()

		viewModel.currentSite.observe(viewLifecycleOwner) {
			Log.i(TAG, "Get Categories")
			viewModel.getCategories()
		}

		viewModel.categoriesList.observe(viewLifecycleOwner) { list ->
			list.forEach { item -> Log.i(TAG, "SITE: $item") }
			configRecyclerView()
		}
	}

	private fun onItemSelected(category: CategoryData) {
		Log.i(TAG, "Category Selected: ${category.name}")
		requireContext().showToast(category.name)
		viewModel.currentCategory.postValue(category)
		Navigation.findNavController(requireView()).navigate(CategoryFragmentDirections.actionCategoryFragmentToSearchByCategoryFragment(viewModel.currentSite.value!!, category))
	}

	private fun configRecyclerView() {
		val manager = LinearLayoutManager(context)

		binding.categoryRecyclerView.layoutManager = manager
		binding.categoryRecyclerView.adapter = CategoryAdapter(viewModel.categoriesList.value ?: listOf()) { category ->
			onItemSelected(category)
		}

		binding.categoryRecyclerView.addItemDecoration(DividerItemDecoration(context, manager.orientation))
	}
}

