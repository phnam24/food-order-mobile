package com.example.foodorderrework.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

object AppType {
    val Font = FontFamily.SansSerif

    val DisplayLogo = TextStyle(
        fontFamily = Font,
        fontSize = 34.sp,
        fontWeight = FontWeight.Bold,
        lineHeight = 40.sp
    )

    val HeadlineLarge = TextStyle(
        fontFamily = Font,
        fontSize = 24.sp,
        fontWeight = FontWeight.Bold,
        lineHeight = 32.sp
    )

    val HeadlineMedium = TextStyle(
        fontFamily = Font,
        fontSize = 20.sp,
        fontWeight = FontWeight.SemiBold,
        lineHeight = 28.sp
    )

    val HeadlineSmall = TextStyle(
        fontFamily = Font,
        fontSize = 18.sp,
        fontWeight = FontWeight.SemiBold,
        lineHeight = 24.sp
    )

    val BodyLarge = TextStyle(
        fontFamily = Font,
        fontSize = 16.sp,
        fontWeight = FontWeight.Normal,
        lineHeight = 24.sp
    )

    val BodyMedium = TextStyle(
        fontFamily = Font,
        fontSize = 14.sp,
        fontWeight = FontWeight.Normal,
        lineHeight = 20.sp
    )

    val LabelLarge = TextStyle(
        fontFamily = Font,
        fontSize = 16.sp,
        fontWeight = FontWeight.Medium,
        lineHeight = 22.sp
    )

    val LabelSmall = TextStyle(
        fontFamily = Font,
        fontSize = 12.sp,
        fontWeight = FontWeight.Medium,
        lineHeight = 16.sp
    )
}

val AppTypography = Typography(
    displayLarge = AppType.DisplayLogo,

    headlineLarge = AppType.HeadlineLarge,
    headlineMedium = AppType.HeadlineMedium,
    headlineSmall = AppType.HeadlineSmall,

    bodyLarge = AppType.BodyLarge,
    bodyMedium = AppType.BodyMedium,

    labelLarge = AppType.LabelLarge,
    labelSmall = AppType.LabelSmall
)