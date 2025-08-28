package com.example.sunnzaraa.repository

import android.database.sqlite.SQLiteConstraintException
import com.example.sunnzaraa.database.dao.UserDao
import com.example.sunnzaraa.database.entities.UserEntity
import javax.inject.Inject

class UserRepository @Inject constructor(
    private val userDao: UserDao
){
    suspend fun registerUser(user: UserEntity): Result<Unit>{
        return try {
            userDao.registerUser(user)
            Result.success(Unit)
        } catch (e: SQLiteConstraintException){
            Result.failure(Exception("User already exists"))
        } catch (e: Exception){
            Result.failure(e)
        }
    }

    suspend fun loginUser(email: String, password:String) : Result<UserEntity>{
        val user = userDao.getUserByEmail(email)
        return if(user != null && user.password == password){
            Result.success(user)
        } else{
            Result.failure(Exception("Invalid credentials"))
        }
    }
}