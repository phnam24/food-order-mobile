package com.example.foodorderrework.feature.auth.domain.usecase

import com.example.foodorderrework.feature.auth.domain.model.User
import com.example.foodorderrework.feature.auth.domain.repository.AuthRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ObserveCurrentUserUseCase @Inject constructor(
    private val repository: AuthRepository,
) {
    operator fun invoke(): Flow<User?> = repository.observeCurrentUser()
}