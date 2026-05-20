package com.kim.android.cleanarchitecturedemo.data.repository.implementation

import com.kim.android.cleanarchitecturedemo.core.state.Resource
import com.kim.android.cleanarchitecturedemo.data.local.dao.UserDao
import com.kim.android.cleanarchitecturedemo.data.mapper.toDomain
import com.kim.android.cleanarchitecturedemo.data.mapper.toEntity
import com.kim.android.cleanarchitecturedemo.data.remote.api.UserApiService
import com.kim.android.cleanarchitecturedemo.domain.model.User
import com.kim.android.cleanarchitecturedemo.domain.repository.UserRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val api: UserApiService,
    private val dao: UserDao
) : UserRepository {
    override fun getUsers(): Flow<Resource<List<User>>> = flow {
        emit(Resource.Loading)
        try {
            val localData = dao.getUsers().first().map { it.toDomain() }
            emit(Resource.Success(localData))
        } catch (e: Exception) {

        }
    }

    override suspend fun refreshUsers() {
        try {
            val remoteUsers = api.getUsers()
            dao.clearUsers()
            dao.insertUsers(remoteUsers.map { it.toEntity() })

        } catch (e: Exception) {
            throw e
        }
    }
}