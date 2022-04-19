package com.herdal.roomdatabaseexercise.repository

import com.herdal.roomdatabaseexercise.model.User
import com.herdal.roomdatabaseexercise.service.UserDao

class UserRepository(private val userDao: UserDao) {

    suspend fun addUser(user: User) {
        userDao.addUser(user)
    }
}