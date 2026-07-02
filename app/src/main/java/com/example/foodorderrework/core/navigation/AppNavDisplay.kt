package com.example.foodorderrework.core.navigation

import androidx.compose.runtime.Composable
import androidx.navigation3.ui.NavDisplay

@Composable
fun AppNavDisplay() {
    val backStack = rememberAppBackStack()

    NavDisplay(
        backStack = backStack,
        onBack = {
            backStack.goBack()
        },
        entryProvider = appEntryProvider(backStack)
    )
}