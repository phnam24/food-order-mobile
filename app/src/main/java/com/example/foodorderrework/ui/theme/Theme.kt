package com.example.foodorderrework.ui.theme

import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val FoodOrderLightColorScheme: ColorScheme = lightColorScheme(
    primary = AppColor.Primary,
    onPrimary = AppColor.OnPrimary,
    primaryContainer = AppColor.PrimaryContainer,
    onPrimaryContainer = AppColor.Primary,

    background = AppColor.Background,
    onBackground = AppColor.TextPrimary,

    surface = AppColor.Surface,
    onSurface = AppColor.TextPrimary,

    surfaceVariant = AppColor.PrimaryContainer,
    onSurfaceVariant = AppColor.TextSecondary,

    outline = AppColor.Outline,

    error = AppColor.Error,
    onError = AppColor.TextOnDark
)

@Composable
fun FoodOrderTheme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = FoodOrderLightColorScheme,
        typography = AppTypography,
        content = content
    )
}