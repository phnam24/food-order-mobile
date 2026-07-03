package com.example.foodorderrework.core.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.foodorderrework.ui.theme.AppColor
import com.example.foodorderrework.ui.theme.AppDimen

enum class BadgeType {
    Success,
    Error,
    Warning,
    Promo,
    Neutral
}

@Composable
fun StatusBadge(
    text: String,
    type: BadgeType,
    modifier: Modifier = Modifier
) {
    val backgroundColor = when (type) {
        BadgeType.Success -> AppColor.Success.copy(alpha = 0.12f)
        BadgeType.Error -> AppColor.Error.copy(alpha = 0.12f)
        BadgeType.Warning -> AppColor.Warning.copy(alpha = 0.12f)
        BadgeType.Promo -> AppColor.PrimaryContainer
        BadgeType.Neutral -> AppColor.Outline
    }

    val contentColor = when (type) {
        BadgeType.Success -> AppColor.Success
        BadgeType.Error -> AppColor.Error
        BadgeType.Warning -> AppColor.Warning
        BadgeType.Promo -> AppColor.Primary
        BadgeType.Neutral -> AppColor.TextSecondary
    }

    Text(
        text = text,
        modifier = modifier
            .background(
                color = backgroundColor,
                shape = RoundedCornerShape(AppDimen.RadiusButtonFull)
            )
            .padding(
                horizontal = AppDimen.SpaceMedium,
                vertical = AppDimen.SpaceExtraSmall
            ),
        color = contentColor,
        style = MaterialTheme.typography.labelSmall
    )
}