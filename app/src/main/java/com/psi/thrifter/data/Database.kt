package com.psi.thrifter.data

import com.psi.thrifter.data.category.CategoryDao
import com.psi.thrifter.data.item.ItemDao
import com.psi.thrifter.data.user.UserDao

class Database private constructor(){
    var categoryDao=CategoryDao()
    var itemDao=ItemDao()
    var userDao=UserDao()
        private set

    companion object {
        @Volatile private var instance: Database? = null

        fun getInstance() =
            instance ?: synchronized(this) {
                instance ?: Database().also { instance = it }
            }
    }
}