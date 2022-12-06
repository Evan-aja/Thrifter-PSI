package com.psi.thrifter.data.category

class CategoryRepository private constructor(private val categoryDao: CategoryDao){
    fun addCategory(category: Category) {
        categoryDao.addCategory(category)
    }

    fun getCategories() = categoryDao.getCategories()

    companion object {
        @Volatile private var instance: CategoryRepository? = null

        fun getInstance(categoryDao: CategoryDao) =
            instance ?: synchronized(this) {
                instance ?: CategoryRepository(categoryDao).also { instance = it }
            }
    }
}