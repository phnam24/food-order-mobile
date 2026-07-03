package com.example.foodorderrework.core.component

import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.foodorderrework.ui.theme.AppColor
import com.example.foodorderrework.ui.theme.AppDimen
import com.example.foodorderrework.ui.theme.AppType

@Composable
fun FoodPrimaryButton(
    content: @Composable (RowScope.() -> Unit),
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
) {
    Button(
        onClick = onClick,
        enabled = enabled,
        modifier = modifier
            .fillMaxWidth()
            .height(AppDimen.PrimaryButtonHeight),
        shape = RoundedCornerShape(AppDimen.RadiusButtonFull),
        colors = ButtonDefaults.buttonColors(
            containerColor = AppColor.Primary,
            contentColor = AppColor.OnPrimary,
            disabledContainerColor = AppColor.Outline,
            disabledContentColor = AppColor.TextSecondary
        ),
        content = content
    )
}