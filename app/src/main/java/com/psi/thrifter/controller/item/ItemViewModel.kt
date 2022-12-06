package com.psi.thrifter.controller.item

import androidx.lifecycle.ViewModel
import com.psi.thrifter.data.item.Item
import com.psi.thrifter.data.item.ItemRepository

class ItemViewModel(private val itemRepository: ItemRepository): ViewModel() {

    fun getItems() = itemRepository.getItems()

    fun addItem(item: Item) = itemRepository.addItem(item)
}