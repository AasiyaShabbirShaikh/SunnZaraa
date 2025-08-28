package com.example.sunnzaraa.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class UserEntity(
    @PrimaryKey val email: String,
    val password : String,
    val name : String,
    val dob : String,
    val gender : String,
)