package com.psi.thrifter.data.user

class UserRepository private constructor(private val userDao: UserDao){
    fun addUser(user: User) {
        userDao.addUser(user)
    }

    fun getUsers() = userDao.getUsers()

    companion object {
        @Volatile private var instance: UserRepository? = null

        fun getInstance(userDao: UserDao) =
            instance ?: synchronized(this) {
                instance ?: UserRepository(userDao).also { instance = it }
            }
    }
}