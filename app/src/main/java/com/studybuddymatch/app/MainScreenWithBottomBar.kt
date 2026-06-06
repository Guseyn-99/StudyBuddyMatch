package com.studybuddymatch.app

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.studybuddymatch.app.ui.*

@Composable
fun MainScreenWithBottomBar() {
    val navController = rememberNavController()

    Scaffold(
        bottomBar = {
            NavigationBar {
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentRoute = navBackStackEntry?.destination?.route

                val items = listOf(
                    "home" to "Главная",
                    "matches" to "Поиск",
                    "chat" to "Чат",
                    "profile" to "Профиль"
                )
                items.forEach { (route, title) ->
                    NavigationBarItem(
                        selected = currentRoute == route,
                        onClick = {
                            navController.navigate(route) {
                                popUpTo(navController.graph.findStartDestination().id) {
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        },
                        icon = { Text(title) },
                        label = { Text(title) },
                        alwaysShowLabel = false
                    )
                }
            }
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = "home",
            modifier = Modifier.padding(innerPadding)
        ) {
            // Основные экраны нижней навигации
            composable("home") { HomeScreen() }
            composable("matches") { MatchesScreen(navController) }
            composable("chat") { ChatScreen(navController, null) }
            composable("profile") { ProfileScreen(navController) }

            // Экран детального профиля партнёра
            composable(
                "partner_profile/{userId}",
                arguments = listOf(navArgument("userId") { type = NavType.StringType })
            ) { backStackEntry ->
                val userId = backStackEntry.arguments?.getString("userId") ?: ""
                PartnerProfileScreen(navController, userId)
            }

            // Экран чата с конкретным партнёром
            composable(
                "chat/{partnerId}",
                arguments = listOf(navArgument("partnerId") { type = NavType.StringType })
            ) { backStackEntry ->
                val partnerId = backStackEntry.arguments?.getString("partnerId") ?: ""
                ChatScreen(navController, partnerId)
            }

            // Экран редактирования профиля
            composable("edit_profile") { EditProfileScreen(navController) }
        }
    }
}