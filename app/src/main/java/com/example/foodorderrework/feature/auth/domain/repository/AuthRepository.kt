package com.example.foodorderrework.feature.auth.domain.repository

import com.example.foodorderrework.feature.auth.domain.model.User
import kotlinx.coroutines.flow.Flow

interface AuthRepository {
    suspend fun login(email: String, password: String): User?
    suspend fun register(user: User): Result<User>
    suspend fun logout()
    suspend fun isEmailTaken(email: String): Boolean

    fun observeCurrentUser(): Flow<User?>
}