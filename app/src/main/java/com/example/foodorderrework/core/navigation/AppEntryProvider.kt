package com.example.foodorderrework.core.navigation

import androidx.compose.runtime.Composable
import androidx.navigation3.runtime.NavBackStack
import androidx.navigation3.runtime.NavEntry
import androidx.navigation3.runtime.NavKey
import com.example.foodorderrework.feature.auth.presentation.login.ui.LoginRoute
import com.example.foodorderrework.feature.splash.ui.FoodOrderSplashRoute

@Composable
fun appEntryProvider(
    backStack: NavBackStack<NavKey>
): (NavKey) -> NavEntry<NavKey> {
    return { key ->
        when (key) {
            StartRoute -> NavEntry(key){
                FoodOrderSplashRoute {
                    backStack.replaceWithRoute(LoginRoute)
                }
            }

            LoginRoute -> NavEntry(key) {
                LoginRoute(
                    onHomeNavigate = {},
                    onRegisterNavigate = {}
                )
            }

            else -> NavEntry(key) {

            }
        }
    }
}