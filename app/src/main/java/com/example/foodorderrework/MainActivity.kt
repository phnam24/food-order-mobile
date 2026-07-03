package com.example.foodorderrework

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.foodorderrework.core.navigation.AppNavDisplay
import com.example.foodorderrework.ui.theme.FoodOrderTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FoodOrderTheme {
                AppNavDisplay()
            }
        }
    }
}