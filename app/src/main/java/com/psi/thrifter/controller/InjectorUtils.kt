package com.psi.thrifter.controller

import com.psi.thrifter.controller.category.CategoryViewModelFactory
import com.psi.thrifter.controller.item.ItemViewModelFactory
import com.psi.thrifter.controller.user.UserViewModelFactory
import com.psi.thrifter.data.Database
import com.psi.thrifter.data.category.CategoryRepository
import com.psi.thrifter.data.item.ItemRepository
import com.psi.thrifter.data.user.UserRepository

object InjectorUtils{
    fun provideUsersViewModelFactory(): UserViewModelFactory {
        val userRepository = UserRepository.getInstance(Database.getInstance().userDao)
        return UserViewModelFactory(userRepository)
    }
    fun provideItemsViewModelFactory(): ItemViewModelFactory {
        val itemRepository = ItemRepository.getInstance(Database.getInstance().itemDao)
        return ItemViewModelFactory(itemRepository)
    }
    fun provideCategoriesViewModelFactory(): CategoryViewModelFactory {
        val categoryRepository = CategoryRepository.getInstance(Database.getInstance().categoryDao)
        return CategoryViewModelFactory(categoryRepository)
    }
}