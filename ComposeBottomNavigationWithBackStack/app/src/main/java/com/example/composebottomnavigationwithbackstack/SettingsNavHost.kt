package com.example.composebottomnavigationwithbackstack

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun SettingsNavHost() {
    val homeNavController = rememberNavController()

    NavHost(navController = homeNavController, startDestination = "settings1") {
        for (i in 0..10) {
            composable("settings$i") {
                GenericScreen(text = "Settings $i", onNectClick = {
                    if (i < 10) {
                        homeNavController.navigate("settings${i + 1}")
                    }
                })
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SettingsNavHostPreview(){
    SettingsNavHost()
}