package com.psi.thrifter.data.category

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class CategoryDao {
    private val categoryList = mutableListOf<Category>()
    private val categorys = MutableLiveData<List<Category>>()

    init {
        categorys.value = categoryList
    }

    fun addCategory(category: Category) {
        categoryList.add(category)
        categorys.value = categoryList
    }
    fun getCategories() = categorys as LiveData<List<Category>>
}