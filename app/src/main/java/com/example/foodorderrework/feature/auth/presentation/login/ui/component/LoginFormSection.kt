package com.example.foodorderrework.feature.auth.presentation.login.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material.icons.outlined.Visibility
import androidx.compose.material.icons.outlined.VisibilityOff
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.example.foodorderrework.core.component.FoodInputTextField
import com.example.foodorderrework.core.component.FoodPrimaryButton
import com.example.foodorderrework.ui.theme.AppColor
import com.example.foodorderrework.ui.theme.AppDimen
import com.example.foodorderrework.ui.theme.AppType

@Composable
fun LoginFormSection(
    email: String,
    password: String,
    errorMessage: String?,
    isPasswordVisible: Boolean,
    onEmailChange: (String) -> Unit,
    onPasswordChange: (String) -> Unit,
    onPasswordVisibilityToggle: () -> Unit,
    onLoginClick: () -> Unit,
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .offset(y = (-20).dp)
            .clip(
                RoundedCornerShape(
                    topStart = AppDimen.RadiusLarge,
                    topEnd = AppDimen.RadiusLarge
                )
            )
            .background(AppColor.Surface)
            .padding(AppDimen.SpaceLarge)
    ) {
        Text(
            text = "Chào mừng trở lại",
            style = AppType.HeadlineMedium
        )

        Spacer(modifier = Modifier.height(AppDimen.SpaceSmall))

        Text(
            text = "Đăng nhập để tận hưởng thiên đường.",
            style = AppType.BodyMedium
        )

        Spacer(modifier = Modifier.height(AppDimen.SpaceLarge))

        errorMessage?.let {
            ErrorInputText(errorMessage)
        }

        FoodInputTextField(
            label = "Email",
            value = email,
            placeholder = "Nhập email của bạn",
            onValueChange = onEmailChange,
            leadingIcon = {
                Icon(
                    imageVector = Icons.Outlined.Email,
                    contentDescription = "Email icon"
                )
            },
        )

        Spacer(modifier = Modifier.height(AppDimen.SpaceSmall))

        PasswordInputField(
            password = password,
            isPasswordVisible = isPasswordVisible,
            onPasswordChange = onPasswordChange,
            onPasswordVisibilityToggle = onPasswordVisibilityToggle
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.End
        ) {
            TextButton(
                onClick = {}
            ) {
                Text(
                    text = "Quên mật khẩu?",
                    style = AppType.LabelSmall,
                    color = AppColor.Primary
                )
            }
        }

        Spacer(modifier = Modifier.height(AppDimen.SpaceLarge))

        FoodPrimaryButton(
            content = {
                Text(
                    text = "Đăng nhập",
                    style = AppType.HeadlineLarge
                )
            },
            onClick = onLoginClick
        )
    }
}

@Composable
fun PasswordInputField(
    password: String,
    isPasswordVisible: Boolean,
    onPasswordChange: (String) -> Unit,
    onPasswordVisibilityToggle: () -> Unit,
) {
    OutlinedTextField(
        value = password,
        onValueChange = onPasswordChange,
        label = {
            Text(
                text = "Mật khẩu",
                style = AppType.LabelLarge
            )
        },
        leadingIcon = {
            Icon(
                imageVector = Icons.Outlined.Lock,
                contentDescription = "Lock icon"
            )
        },
        placeholder = {
            Text(
                text = "Nhập mật khẩu",
                style = AppType.BodyMedium,
                color = AppColor.TextSecondary
            )
        },
        trailingIcon = {
            IconButton(
                onClick = onPasswordVisibilityToggle
            ) {
                Icon(
                    imageVector = if (isPasswordVisible) Icons.Outlined.Visibility else Icons.Outlined.VisibilityOff,
                    contentDescription = "Password visibility"
                )
            }
        },
        singleLine = true,
        visualTransformation = if (isPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(AppDimen.RadiusInput)
    )
}

@Composable
fun ErrorInputText(
    message: String
) {
    Text(
        text = message,
        style = AppType.BodyLarge,
        color = AppColor.Error
    )
    Spacer(modifier = Modifier.height(AppDimen.SpaceExtraSmall))
}