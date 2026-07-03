package com.example.foodorderrework.feature.auth.presentation.login.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.example.foodorderrework.ui.theme.AppColor
import com.example.foodorderrework.ui.theme.AppDimen
import com.example.foodorderrework.ui.theme.AppType

@Composable
fun LoginBanner() {
    val imgUrl = "https://lh3.googleusercontent.com/aida-public/AB6AXuDC8jQJmICWpX5C18XNDNFBchOMLcqAIZJlM9f-jBT8am2PuQw7IJ3GMv0PYJ44b2KtYtP19cGLmUJeoohrvYDx2Bj-rR1kaDFPgXTm53QuCgiHMlsgZS0meK3Dtj-IIQ8BJgyitVJ1CKNpklEdm4t4iSOVwNVkViG6hMWXXvAxhSTSE9yVfA_xtZfdBmKwrVIdwbk5SK7GFtQysc2AWSF4_L8-Nq6TTkleo4FMKT34TAOq2OJ0hmvm689OODciNUJPqir__vnsurg"

    Box(
        contentAlignment = Alignment.BottomStart,
        modifier = Modifier
            .fillMaxWidth()
            .height(256.dp),
    ) {
        AsyncImage(
            model = imgUrl,
            contentDescription = "Banner Image",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    Brush.verticalGradient(
                        colors = listOf(
                            Color.Transparent,
                            Color.Black.copy(alpha = 0.6f)
                        )
                    )
                )
        )

        Column(
            modifier = Modifier.padding(AppDimen.SpaceLarge)
        ) {
            Text(
                text = "Food Order",
                style = AppType.HeadlineLarge,
                color = AppColor.TextOnDark
            )

            Spacer(modifier = Modifier.height(AppDimen.SpaceSmall))

            Text(
                text = "Giao hàng nhanh chóng, hương vị tuyệt hảo.",
                style = AppType.LabelLarge,
                color = AppColor.TextOnDark.copy(alpha = 0.8f)
            )
        }
    }
}