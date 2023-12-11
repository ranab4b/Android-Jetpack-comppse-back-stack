package com.example.composebottomnavigationwithbackstack

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun HomeNavHost() {
    val homeNavController = rememberNavController()

    NavHost(navController = homeNavController, startDestination = "home1") {
        for (i in 0..10) {
            composable("home$i") {
                GenericScreen(text = "Home $i", onNectClick = {
                    if (i < 10) {
                        homeNavController.navigate("home${i + 1}")
                    }
                })
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeNavHostPreview(){
    HomeNavHost()
}