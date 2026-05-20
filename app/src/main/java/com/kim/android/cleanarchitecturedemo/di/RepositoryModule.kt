package com.kim.android.cleanarchitecturedemo.di

import com.kim.android.cleanarchitecturedemo.data.repository.implementation.UserRepositoryImpl
import com.kim.android.cleanarchitecturedemo.domain.repository.UserRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindUserRepository(impl: UserRepositoryImpl): UserRepository

}