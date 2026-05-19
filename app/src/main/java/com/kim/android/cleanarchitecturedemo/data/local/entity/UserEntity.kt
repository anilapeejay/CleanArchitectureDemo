package com.kim.android.cleanarchitecturedemo.data.local.entity

import androidx.room.PrimaryKey

data class UserEntity(@PrimaryKey val id: Int, val name: String, val email: String)