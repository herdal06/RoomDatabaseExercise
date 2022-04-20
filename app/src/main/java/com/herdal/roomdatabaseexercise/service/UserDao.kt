package com.herdal.roomdatabaseexercise.service

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.herdal.roomdatabaseexercise.model.User

@Dao
interface UserDao {
    @Insert
    suspend fun addUser(user: User)
    @Query("SELECT * FROM user ORDER BY id ASC")
    fun listAllUsers() : LiveData<List<User>>
}