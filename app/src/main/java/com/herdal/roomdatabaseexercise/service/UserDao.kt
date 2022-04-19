package com.herdal.roomdatabaseexercise.service

import androidx.room.Dao
import androidx.room.Insert
import com.herdal.roomdatabaseexercise.model.User

@Dao
interface UserDao {
    @Insert
    suspend fun addUser(user: User)
}