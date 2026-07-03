package com.example.foodorderrework.feature.auth.domain.usecase

import android.R.attr.name
import com.example.foodorderrework.feature.auth.domain.model.Role
import com.example.foodorderrework.feature.auth.domain.model.User
import com.example.foodorderrework.feature.auth.domain.repository.AuthRepository
import com.example.foodorderrework.feature.auth.domain.util.EmailValidator
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.FlowCollector
import kotlinx.coroutines.flow.flow
import java.util.UUID
import javax.inject.Inject

class RegisterUseCase @Inject constructor(
    private val authRepository: AuthRepository
) {
    suspend operator fun invoke(
        user: User
    ): Result<User> {
        validate(user.name, user.email, user.password, user.role)?.let { errorMessage ->
            return Result.failure(IllegalArgumentException(errorMessage))
        }

        val emailTaken = authRepository.isEmailTaken(user.email.trim())
        if (emailTaken) {
            return Result.failure(IllegalStateException("Email đã được sử dụng"))
        }

        val newUser = user.copy(
            id = UUID.randomUUID().toString(),
            avatarUrl = ""
        )

        return authRepository.register(newUser)
    }

    private fun validate(name: String, email: String, password: String, role: Role): String? = when {
        name.isBlank() -> "Tên không được để trống"
        !EmailValidator.isValid(email) -> "Email không hợp lệ"
        password.length < 6 -> "Mật khẩu tối thiểu 6 ký tự"
        role == Role.ADMIN -> "Không được tự đăng ký vai trò Admin"
        else -> null
    }
}

