package com.example.composebottomnavigationwithbackstack

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.compose.material3.NavigationBar
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.composebottomnavigationwithbackstack.ui.theme.ComposeBottomNavigationWithBackStackTheme

@Composable
fun BottomNavigationComposable(rootNAvController: NavHostController, navBackStackEntry: NavBackStackEntry?) {
    NavigationBar {
        bottomNavigationItems.forEach { bottomNavigationItem ->
            val isSelected = bottomNavigationItem.title.lowercase() == navBackStackEntry?.destination?.route
            NavigationBarItem(selected = isSelected, onClick = {

                rootNAvController.navigate(bottomNavigationItem.title.lowercase()) {
                    popUpTo(rootNAvController.graph.findStartDestination().id) {
                        saveState = true
                    }
                    launchSingleTop = true
                    restoreState = true
                }

            }, icon = {
                Icon(
                    imageVector = if (isSelected) {
                        bottomNavigationItem.iconEnabled
                    } else {
                        bottomNavigationItem.iconDisabled
                    }, contentDescription = null
                )

            }, label = { Text(text = bottomNavigationItem.title) }
            )
        }
    }
}

data class BottomNavigationItem(
    val iconEnabled: ImageVector,
    val iconDisabled: ImageVector,
    val title: String
)

val bottomNavigationItems = listOf(
    BottomNavigationItem(
        iconEnabled = Icons.Filled.Home,
        iconDisabled = Icons.Outlined.Home,
        title = "home"
    ),
    BottomNavigationItem(
        iconEnabled = Icons.Filled.Email,
        iconDisabled = Icons.Outlined.Email,
        title = "email"
    ),
    BottomNavigationItem(
        iconEnabled = Icons.Filled.Settings,
        iconDisabled = Icons.Outlined.Settings,
        title = "settings"
    )
)


@Preview(showBackground = true)
@Composable
fun BottomNavigationComposablePreview() {
    ComposeBottomNavigationWithBackStackTheme {
        val rootNavController = rememberNavController()
        val navBackStackEntry by rootNavController.currentBackStackEntryAsState()
        BottomNavigationComposable(rootNavController, navBackStackEntry )
    }
}



