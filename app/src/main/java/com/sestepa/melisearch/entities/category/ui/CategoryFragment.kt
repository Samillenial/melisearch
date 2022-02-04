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

		viewModel.currentSite.observe(viewLifecycleOwner) { site ->
			Log.i(TAG, "Try Get Categories to ${site.name}")
			viewModel.getCategories()
		}

		viewModel.categoriesList.observe(viewLifecycleOwner) { categories ->

			if(categories.isEmpty()) {
				Log.e(TAG, "Download CATEGORY fail")

				requireContext().showToast(getString(R.string.try_again))
				requireActivity().onBackPressed()
			}
			else {
				Log.i(TAG, "Download CATEGORY successful !!!")
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

