package com.example.foodorderrework.feature.auth.presentation.login.ui.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.foodorderrework.ui.theme.AppColor
import com.example.foodorderrework.ui.theme.AppColor.Surface
import com.example.foodorderrework.ui.theme.AppType

@Composable
fun ErrorMessageBar(
    message: String,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp, vertical = 12.dp),
        contentAlignment = Alignment.Center
    ) {
        Surface(
            color = AppColor.DangerSoft,
            shape = RoundedCornerShape(18.dp),
            shadowElevation = 4.dp
        ) {
            Text(
                text = message,
                style = AppType.LabelLarge,
                color = AppColor.Error,
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 12.dp)
            )
        }
    }
}