package com.kim.android.cleanarchitecturedemo.data.mapper

import com.kim.android.cleanarchitecturedemo.data.local.entity.UserEntity
import com.kim.android.cleanarchitecturedemo.data.remote.dto.UserDto
import com.kim.android.cleanarchitecturedemo.domain.model.User

class UserMapper {
    fun UserDto.toEntity(): UserEntity {
        return UserEntity(id = id, name = name, email = email)
    }

    fun UserEntity.toDomain(): User {
        return User(id = id, name = name, email = email)
    }
}