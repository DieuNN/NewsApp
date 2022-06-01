package com.dieunn.vietceteraclone

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.dieunn.vietceteraclone.ui.screens.AccountScreen
import com.dieunn.vietceteraclone.ui.screens.HomeScreen
import com.dieunn.vietceteraclone.ui.screens.NewsDetailScreen

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun AppNavigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "home") {
        composable(route = "home") {
            HomeScreen(navController = navController)
        }
        composable(route = "account") {
            AccountScreen()
        }
        composable(
            route = "detail/{link}",
            arguments = listOf(
                navArgument("link") {
                    type = NavType.StringType
                    defaultValue = ""
                    nullable = false
                }
            )
        ) { entry ->
            NewsDetailScreen(link = entry.arguments?.getString("link")!!)
        }
    }
}