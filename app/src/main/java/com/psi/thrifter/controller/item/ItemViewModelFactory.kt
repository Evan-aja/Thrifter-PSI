package com.psi.thrifter.controller.item

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.psi.thrifter.data.item.ItemRepository

class ItemViewModelFactory(private val itemRepository: ItemRepository): ViewModelProvider.NewInstanceFactory() {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ItemViewModel(itemRepository) as T
    }
}