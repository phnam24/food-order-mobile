package com.example.foodorderrework.feature.auth.presentation.common_component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.foodorderrework.R
import com.example.foodorderrework.ui.theme.AppColor
import com.example.foodorderrework.ui.theme.AppDimen
import com.example.foodorderrework.ui.theme.AppType
@Composable
fun SocialLoginSection(
    isLogin: Boolean = true,
    onButtonTextClick: () -> Unit
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .background(AppColor.Surface)
            .padding(AppDimen.SpaceMedium)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth()
        ) {
            HorizontalDivider(
                thickness = AppDimen.BorderWidth,
                color = AppColor.Success,
                modifier = Modifier.weight(1f)
            )

            Text(
                text = "HOẶC ĐĂNG TIẾP TỤC VỚI",
                style = AppType.LabelSmall,
                modifier = Modifier
                    .padding(AppDimen.SpaceSmall),
            )

            HorizontalDivider(
                thickness = AppDimen.BorderWidth,
                color = AppColor.Success,
                modifier = Modifier.weight(1f)
            )
        }

        Spacer(modifier = Modifier.height(AppDimen.SpaceMedium))

        SocialIconRow()

        Spacer(modifier = Modifier.height(AppDimen.SpaceMedium))

        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = if (isLogin) "Chưa có tài khoản?" else "Đã có tài khoản?",
                style = AppType.BodyLarge
            )

            TextButton(
                onClick = onButtonTextClick
            ) {
                Text(
                    text = if (isLogin) "Đăng ký ngay" else "Đăng nhập ngay",
                    style = AppType.LabelLarge,
                    color = AppColor.Primary
                )
            }
        }
    }
}

@Composable
fun SocialIconRow() {
    val socialIconList = listOf(
        R.drawable.ic_google,
        R.drawable.ic_facebook,
        R.drawable.ic_instagram
    )

    Row(
        horizontalArrangement = Arrangement.spacedBy(AppDimen.SpaceMedium, Alignment.CenterHorizontally),
        modifier = Modifier.fillMaxWidth()
    ) {
        socialIconList.forEach {
            SocialItem(drawableResId = it)
        }
    }
}

@Composable
fun SocialItem(
    drawableResId: Int,
    modifier: Modifier = Modifier
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .size(48.dp)
            .clip(CircleShape)
            .border(
                width = AppDimen.BorderWidth,
                color = AppColor.Primary,
                shape = CircleShape
            ),
    ) {
        IconButton(onClick = {}) {
            Icon(
                painter = painterResource(drawableResId),
                contentDescription = "Social Icon",
                tint = Color.Unspecified,
                modifier = Modifier.size(AppDimen.IconSmall)
            )
        }
    }
}