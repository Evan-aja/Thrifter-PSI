package com.psi.thrifter.controller.category

import androidx.lifecycle.ViewModel
import com.psi.thrifter.data.category.Category
import com.psi.thrifter.data.category.CategoryRepository

class CategoryViewModel(private val categoryRepository: CategoryRepository): ViewModel() {

    fun getCategories() = categoryRepository.getCategories()

    fun addCategory(category: Category) = categoryRepository.addCategory(category)
}