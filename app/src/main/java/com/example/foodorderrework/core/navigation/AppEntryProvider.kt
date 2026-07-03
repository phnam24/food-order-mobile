package com.example.foodorderrework.core.navigation

import androidx.compose.runtime.Composable
import androidx.navigation3.runtime.NavBackStack
import androidx.navigation3.runtime.NavEntry
import androidx.navigation3.runtime.NavKey

@Composable
fun appEntryProvider(
    backStack: NavBackStack<NavKey>
): (NavKey) -> NavEntry<NavKey> {
    return { key ->
        when (key) {
            StartRoute -> NavEntry(key){

            }

            else -> NavEntry(key) {

            }
        }
    }
}