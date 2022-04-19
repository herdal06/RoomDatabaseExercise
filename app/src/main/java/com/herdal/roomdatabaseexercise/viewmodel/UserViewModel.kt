package com.herdal.roomdatabaseexercise.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.herdal.roomdatabaseexercise.model.User
import com.herdal.roomdatabaseexercise.repository.UserRepository
import com.herdal.roomdatabaseexercise.service.UserDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserViewModel(application: Application): AndroidViewModel(application) {

    private val repository: UserRepository

    init {
        val userDao = UserDatabase.createDatabase(application).userDao()
        repository = UserRepository(userDao)
    }

    fun addUser(user: User) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addUser(user)
        }
    }
}