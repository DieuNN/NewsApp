package com.dieunn.vietceteraclone.ui.components

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState

@Composable
fun BottomBar(
    navController: NavController
) {
    BottomNavigation(
        backgroundColor = Color.White,
        elevation = 1.dp,
    ) {
        val backStackEntry = navController.currentBackStackEntryAsState()
        BottomNavigationItem(
            selected = backStackEntry.value?.destination?.route == "home",
            onClick = {
                navController.navigate("home")
            },
            icon = {
                Icon(imageVector = Icons.Default.Home, contentDescription = null)
            },
            selectedContentColor = Color.Green,
            unselectedContentColor = Color.Gray
        )
        BottomNavigationItem(
            selected = backStackEntry.value?.destination?.route == "account",
            onClick = {
                navController.navigate("account")
            },
            icon = {
                Icon(imageVector = Icons.Default.Person, contentDescription = null)
            },
            selectedContentColor = Color.Green,
            unselectedContentColor = Color.Gray
        )
    }
}