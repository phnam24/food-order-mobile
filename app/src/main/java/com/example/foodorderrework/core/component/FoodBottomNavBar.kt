package com.example.foodorderrework.core.component

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.ReceiptLong
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Percent
import androidx.compose.material.icons.outlined.PersonOutline
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.foodorderrework.ui.theme.AppColor
import com.example.foodorderrework.ui.theme.AppDimen

enum class BottomNavTab {
    Home,
    Offers,
    Orders,
    Profile
}

@Composable
fun FoodBottomNavBar(
    selectedTab: BottomNavTab = BottomNavTab.Home,
    onTabSelected: (BottomNavTab) -> Unit,
    @SuppressLint("ModifierParameter") modifier: Modifier = Modifier
) {
    NavigationBar(
        modifier = modifier.height(AppDimen.BottomNavBarHeight),
        containerColor = AppColor.Surface
    ) {

        val navItemColor = NavigationBarItemDefaults.colors(
            selectedIconColor = AppColor.Primary,
            selectedTextColor = AppColor.Primary,
            unselectedIconColor = AppColor.TextPrimary,
            unselectedTextColor = AppColor.TextPrimary,
            indicatorColor = Color.Transparent
        )

        NavigationBarItem(
            selected = selectedTab == BottomNavTab.Home,
            icon = {
                Icon(
                    imageVector = Icons.Outlined.Home,
                    contentDescription = "Home Page",
                    modifier = modifier.size(AppDimen.IconMedium)
                )
            },
            label = {
                Text(
                    text = "Trang Chủ",
                    style = MaterialTheme.typography.labelMedium
                )
            },
            colors = navItemColor,
            onClick = { onTabSelected(selectedTab) }
        )

        NavigationBarItem(
            selected = selectedTab == BottomNavTab.Offers,
            icon = {
                Icon(
                    imageVector = Icons.Outlined.Percent,
                    contentDescription = "Offers Page",
                    modifier = modifier.size(AppDimen.IconMedium)
                )
            },
            label = {
                Text(
                    text = "Ưu Đãi",
                    style = MaterialTheme.typography.labelMedium
                )
            },
            colors = navItemColor,
            onClick = { onTabSelected(selectedTab) }
        )

        NavigationBarItem(
            selected = selectedTab == BottomNavTab.Orders,
            icon = {
                Icon(
                    imageVector = Icons.AutoMirrored.Outlined.ReceiptLong,
                    contentDescription = "Orders Page",
                    modifier = modifier.size(AppDimen.IconMedium)
                )
            },
            label = {
                Text(
                    text = "Đơn Hàng",
                    style = MaterialTheme.typography.labelMedium
                )
            },
            colors = navItemColor,
            onClick = { onTabSelected(selectedTab) }
        )

        NavigationBarItem(
            selected = selectedTab == BottomNavTab.Profile,
            icon = {
                Icon(
                    imageVector = Icons.Outlined.PersonOutline,
                    contentDescription = "Profile Page",
                    modifier = modifier.size(AppDimen.IconMedium)
                )
            },
            label = {
                Text(
                    text = "Tôi",
                    style = MaterialTheme.typography.labelMedium
                )
            },
            colors = navItemColor,
            onClick = { onTabSelected(selectedTab) }
        )
    }
}