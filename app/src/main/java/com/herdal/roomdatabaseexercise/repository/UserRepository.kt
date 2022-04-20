package com.herdal.roomdatabaseexercise.repository

import androidx.lifecycle.LiveData
import com.herdal.roomdatabaseexercise.model.User
import com.herdal.roomdatabaseexercise.service.UserDao

class UserRepository(private val userDao: UserDao) {

   val listAllUsers: LiveData<List<User>> = userDao.listAllUsers()

    suspend fun addUser(user: User) {
        userDao.addUser(user)
    }
}