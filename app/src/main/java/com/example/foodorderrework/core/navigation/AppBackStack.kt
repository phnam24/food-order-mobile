package com.example.foodorderrework.core.navigation

import androidx.compose.runtime.Composable
import androidx.navigation3.runtime.NavBackStack
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.rememberNavBackStack

@Composable
fun rememberAppBackStack(): NavBackStack<NavKey> {
    return rememberNavBackStack(StartRoute)
}

fun NavBackStack<NavKey>.navigate(route: NavKey) {
    add(route)
}

fun NavBackStack<NavKey>.goBack() {
    if (size > 1) {
        removeLastOrNull()
    }
}