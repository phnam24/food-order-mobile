package com.example.foodorderrework.feature.auth.di

import com.example.foodorderrework.feature.auth.data.repository.AuthRepositoryImpl
import com.example.foodorderrework.feature.auth.domain.repository.AuthRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class AuthModule {

    @Binds
    abstract fun bindAuthRepository(
        impl: AuthRepositoryImpl,
    ): AuthRepository
}