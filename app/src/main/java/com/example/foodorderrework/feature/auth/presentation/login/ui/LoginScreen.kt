package com.example.foodorderrework.feature.auth.presentation.login.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Snackbar
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.foodorderrework.feature.auth.presentation.login.state.LoginUiState
import com.example.foodorderrework.feature.auth.presentation.login.ui.component.ErrorMessageBar
import com.example.foodorderrework.feature.auth.presentation.login.ui.component.LoginBanner
import com.example.foodorderrework.feature.auth.presentation.login.ui.component.LoginFormSection
import com.example.foodorderrework.feature.auth.presentation.login.ui.component.SocialLoginSection
import com.example.foodorderrework.ui.theme.AppColor
import com.example.foodorderrework.ui.theme.AppDimen
import com.example.foodorderrework.ui.theme.AppType

@Composable
fun LoginScreen(
    uiState: LoginUiState,
    onEmailChange: (String) -> Unit,
    onPasswordChange: (String) -> Unit,
    onPasswordVisibilityToggle: () -> Unit,
    onLoginClick: () -> Unit,
    onRegisterTextClick: () -> Unit
) {
    Scaffold(
        snackbarHost = {
            if ( uiState.errorMessage.isNotBlank()) {
                ErrorMessageBar(uiState.errorMessage)
            }
        }
    ) { paddingValues ->
        if (uiState.isLoading) {
            LoginLoadingScreen()
        } else {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
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
    }
}

@Composable
fun LoginLoadingScreen() {
    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black.copy(alpha = 0.3f)),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .size(264.dp, 196.dp)
                .clip(RoundedCornerShape(AppDimen.RadiusLarge))
                .shadow(
                    elevation = AppDimen.CardElevation,
                    shape = RoundedCornerShape(AppDimen.RadiusLarge)
                )
                .background(AppColor.Surface),
            contentAlignment = Alignment.Center
        ) {
            Column(
                verticalArrangement = Arrangement.spacedBy(AppDimen.SpaceSmall),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                CircularProgressIndicator(
                    color = AppColor.Primary,
                    strokeWidth = AppDimen.SpaceExtraSmall,
                    modifier = Modifier.size(72.dp)
                )

                Text(
                    text = "Đang đăng nhập...",
                    style = AppType.LabelLarge,
                    color = AppColor.TextPrimary
                )
            }
        }
    }
}