package com.herdal.roomdatabaseexercise.service

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.herdal.roomdatabaseexercise.model.User

@Database(entities = [User::class], version = 1)
abstract class UserDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao

    companion object {
        @Volatile // visible to other threads
        private var INSTANCE: UserDatabase? = null

        fun createDatabase(context: Context) : UserDatabase {
            val tempInstance = INSTANCE
            if(tempInstance != null) // already exists
                return tempInstance

            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    UserDatabase::class.java,
                    "user_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}