package com.example.foodorderrework.feature.auth.domain.usecase

import com.example.foodorderrework.feature.auth.domain.model.User
import com.example.foodorderrework.feature.auth.domain.repository.AuthRepository
import kotlinx.coroutines.delay
import javax.inject.Inject
import kotlin.time.Duration.Companion.milliseconds

class LoginUseCase @Inject constructor(
    private val repository: AuthRepository
) {
    suspend operator fun invoke(email: String, password: String): User? {
        require(email.isNotBlank()) { "Email không được để trống" }
        require(password.isNotBlank()) { "Mật khẩu không được để trống" }

        delay(2_000L.milliseconds)
        return repository.login(email.trim(), password)
    }
}