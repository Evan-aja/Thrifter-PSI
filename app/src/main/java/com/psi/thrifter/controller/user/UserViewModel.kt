package com.psi.thrifter.controller.user

import androidx.lifecycle.ViewModel
import com.psi.thrifter.data.user.User
import com.psi.thrifter.data.user.UserRepository

class UserViewModel(private val userRepository: UserRepository): ViewModel() {

    fun getUsers() = userRepository.getUsers()

    fun addUser(user: User) = userRepository.addUser(user)
}