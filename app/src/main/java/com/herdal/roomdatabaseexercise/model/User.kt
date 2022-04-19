package com.herdal.roomdatabaseexercise.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity()
data class User(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val email: String,
    val userName: String,
    val password: String,
    val age: Int
    ) {
}