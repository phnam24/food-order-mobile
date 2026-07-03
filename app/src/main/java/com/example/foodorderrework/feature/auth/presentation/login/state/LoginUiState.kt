package com.example.foodorderrework.feature.auth.presentation.login.state

data class LoginUiState(
    val email: String = "",
    val password: String = "",
    val errorMessage: String = "",
    val isPasswordVisible: Boolean = false,
    val isLoading: Boolean = false
)