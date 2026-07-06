package com.example.foodorderrework.feature.auth.presentation.register.state

import com.example.foodorderrework.feature.auth.domain.model.Role

enum class RegisterStep {
    ROLE_SELECTION,
    REGISTER
}

data class RegisterUiState(
    val email: String = "",
    val emailError: String? = null,
    val password: String = "",
    val passwordError: String? = null,
    val confirmPassword: String = "",
    val confirmPasswordError: String? = null,
    val selectedStep: RegisterStep = RegisterStep.ROLE_SELECTION,
    val selectedRole: Role = Role.CUSTOMER,
    val isLoading: Boolean = false
)