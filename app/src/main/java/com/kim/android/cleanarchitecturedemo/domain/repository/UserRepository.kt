package com.kim.android.cleanarchitecturedemo.domain.repository

import com.kim.android.cleanarchitecturedemo.core.state.Resource
import com.kim.android.cleanarchitecturedemo.domain.model.User
import kotlinx.coroutines.flow.Flow

interface UserRepository {

    fun getUsers(): Flow<Resource<List<User>>>
    suspend fun refreshUsers()
}