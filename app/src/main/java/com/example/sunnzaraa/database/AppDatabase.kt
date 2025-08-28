package com.example.sunnzaraa.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.sunnzaraa.database.dao.UserDao
import com.example.sunnzaraa.database.entities.UserEntity

@Database(entities = [UserEntity::class],  version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
}