package com.kim.android.cleanarchitecturedemo.core.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.kim.android.cleanarchitecturedemo.data.local.dao.UserDao
import com.kim.android.cleanarchitecturedemo.data.local.entity.UserEntity

@Database(entities = [UserEntity::class], version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun userDao() : UserDao
}