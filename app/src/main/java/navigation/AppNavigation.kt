package com.studybuddymatch.app.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.studybuddymatch.app.MainScreenWithBottomBar
import com.studybuddymatch.app.ui.LoginScreen
import com.studybuddymatch.app.ui.RegisterScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "login"
    ) {
        composable("login") {
            LoginScreen(navController)
        }

        composable("register") {
            RegisterScreen(navController)
        }

        composable("main") {
            MainScreenWithBottomBar()
        }
    }
}