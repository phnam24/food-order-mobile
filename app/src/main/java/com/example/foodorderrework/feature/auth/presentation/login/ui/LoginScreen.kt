package com.example.foodorderrework.feature.auth.presentation.login.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.foodorderrework.feature.auth.presentation.login.state.LoginUiState
import com.example.foodorderrework.feature.auth.presentation.login.ui.component.LoginBanner
import com.example.foodorderrework.feature.auth.presentation.login.ui.component.LoginFormSection
import com.example.foodorderrework.feature.auth.presentation.login.ui.component.SocialLoginSection

@Composable
fun LoginScreen(
    uiState: LoginUiState,
    onEmailChange: (String) -> Unit,
    onPasswordChange: (String) -> Unit,
    onPasswordVisibilityToggle: () -> Unit,
    onLoginClick: () -> Unit,
    onRegisterTextClick: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        LoginBanner()

        LoginFormSection(
            email = uiState.email,
            password = uiState.password,
            isPasswordVisible = uiState.isPasswordVisible,
            onEmailChange = onEmailChange,
            onPasswordChange = onPasswordChange,
            onPasswordVisibilityToggle = onPasswordVisibilityToggle,
            onLoginClick = onLoginClick
        )

        SocialLoginSection(
            onRegisterTextClick = onRegisterTextClick
        )
    }
}