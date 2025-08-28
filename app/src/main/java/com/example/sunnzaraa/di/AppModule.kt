package com.example.sunnzaraa.di

import android.content.Context
import android.provider.DocumentsContract.Root
import androidx.room.Room
import com.example.sunnzaraa.database.AppDatabase
import com.example.sunnzaraa.database.dao.UserDao
import com.example.sunnzaraa.repository.UserRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)

object AppModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context) : AppDatabase {
        return Room.databaseBuilder(context, AppDatabase::class.java, "sunnzaraa_db")
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun provideUserDao(userDb : AppDatabase): UserDao = userDb.userDao()

    @Provides
    @Singleton
    fun provideUserRepository(userDao: UserDao): UserRepository = UserRepository(userDao)
}