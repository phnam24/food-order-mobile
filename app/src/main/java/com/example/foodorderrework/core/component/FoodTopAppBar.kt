package com.example.foodorderrework.core.component

import android.graphics.drawable.Icon
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.foodorderrework.ui.theme.AppColor
import com.example.foodorderrework.ui.theme.AppDimen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FoodBaseTopAppBar(
    title: String,
    onBack: () -> Unit,
    modifier: Modifier = Modifier
) {
    TopAppBar(
        title = {
            Text(
                text = title,
                style = MaterialTheme.typography.headlineLarge
            )
        },
        navigationIcon = {
            IconButton(
                onClick = onBack
            ) {
                Icon(
                    imageVector = Icons.Default.ArrowBackIosNew,
                    contentDescription = "Go Back Icon Button"
                )
            }
        },
        modifier = modifier
            .height(AppDimen.TopAppBarHeight)
            .background(AppColor.Surface)
    )
}