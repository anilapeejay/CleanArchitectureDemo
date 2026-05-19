package com.kim.android.cleanarchitecturedemo.data.remote.api

import com.kim.android.cleanarchitecturedemo.data.remote.dto.UserDto
import retrofit2.http.GET

interface UserApiService {

    @GET("users")
    suspend fun getUsers(): List<UserDto>
}