package com.kim.android.cleanarchitecturedemo.domain.usecase

import com.kim.android.cleanarchitecturedemo.core.state.Resource
import com.kim.android.cleanarchitecturedemo.domain.model.User
import com.kim.android.cleanarchitecturedemo.domain.repository.UserRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetUsersUseCase @Inject constructor(private val repository: UserRepository) {
    operator fun invoke(): Flow<Resource<List<User>>> {
        return repository.getUsers()
    }
}