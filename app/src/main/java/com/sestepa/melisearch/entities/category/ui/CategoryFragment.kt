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
import com.sestepa.melisearch.core.PREFIX_TAG
import com.sestepa.melisearch.core.showToast
import com.sestepa.melisearch.databinding.FragmentCategoryBinding
import com.sestepa.melisearch.entities.category.domain.CategoryData
import com.sestepa.melisearch.entities.site.ui.SiteViewModel
import dagger.hilt.android.AndroidEntryPoint

private const val TAG = PREFIX_TAG + "CategoryFragment"

@AndroidEntryPoint
class CategoryFragment: Fragment(R.layout.fragment_category) {

	private lateinit var binding: FragmentCategoryBinding
	private val viewModel: SiteViewModel by viewModels()

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		Log.i(TAG, "onViewCreated")
		super.onViewCreated(view, savedInstanceState)

		binding = FragmentCategoryBinding.bind(view)
		viewModel.getCurrentSite()

		viewModel.currentSite.observe(viewLifecycleOwner) { site ->
			Log.i(TAG, "Try Get Categories to ${site.name}")
			viewModel.getCategories()
		}

		viewModel.categoriesList.observe(viewLifecycleOwner) { categories ->

			if(categories.isEmpty()) {
				Log.e(TAG, "categories is empty")

				requireContext().showToast(getString(R.string.try_again))
				requireActivity().onBackPressed()
			} else {
				Log.i(TAG, "Get CATEGORY successful !!!")
				categories.forEach { category -> Log.i(TAG, "CATEGORY: $category") }

				configRecyclerView()
			}
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

		binding.categoryRecycler.layoutManager = manager
		binding.categoryRecycler.adapter = CategoryAdapter(viewModel.categoriesList.value ?: listOf()) { category ->
			onItemSelected(category)
		}

		binding.categoryRecycler.addItemDecoration(DividerItemDecoration(context, manager.orientation))
	}
}

