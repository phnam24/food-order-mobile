package com.example.foodorderrework.feature.auth.data.repository

import com.example.foodorderrework.feature.auth.data.mock.MockUsers
import com.example.foodorderrework.feature.auth.domain.model.User
import com.example.foodorderrework.feature.auth.domain.repository.AuthRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AuthRepositoryImpl @Inject constructor() : AuthRepository {
    private val usersFlow = MutableStateFlow(MockUsers.users)
    private val currentUserFlow = MutableStateFlow<User?>(null)

    override suspend fun login(email: String, password: String): User? {
        val matchedUser = usersFlow.value.firstOrNull {
            it.email == email && it.password == password
        }
        if (matchedUser != null) currentUserFlow.value = matchedUser
        return matchedUser
    }

    override suspend fun register(user: User): Result<User> {
        usersFlow.value += user
        currentUserFlow.value = user
        return Result.success(user)
    }

    override suspend fun logout() {
        currentUserFlow.value = null
    }

    override suspend fun isEmailTaken(email: String): Boolean =
        usersFlow.value.any { it.email.equals(email, ignoreCase = true) }

    override fun observeCurrentUser(): Flow<User?> = currentUserFlow.asStateFlow()
}