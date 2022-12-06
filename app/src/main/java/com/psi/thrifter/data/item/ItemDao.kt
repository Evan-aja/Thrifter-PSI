package com.psi.thrifter.data.item

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class ItemDao {
    private val itemList = mutableListOf<Item>()
    private val items = MutableLiveData<List<Item>>()

    init {
        items.value = itemList
    }

    fun addItem(item: Item) {
        itemList.add(item)
        items.value = itemList
    }
    fun getItems() = items as LiveData<List<Item>>
}