package com.example.composebottomnavigationwithbackstack

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun EmailNavHost() {
    val homeNavController = rememberNavController()

    NavHost(navController = homeNavController, startDestination = "email1") {
        for (i in 0..10) {
            composable("email$i") {
                GenericScreen(text = "Email $i", onNectClick = {
                    if (i < 10) {
                        homeNavController.navigate("email${i + 1}")
                    }
                })
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun EmailNavHostPreview(){
    EmailNavHost()
}