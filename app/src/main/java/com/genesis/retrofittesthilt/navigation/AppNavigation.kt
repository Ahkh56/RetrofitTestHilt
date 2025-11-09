package com.genesis.retrofittesthilt.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.genesis.core.navigation.Screen
import com.genesis.feature_home.presentation.HomeScreen
import com.genesis.feature_welcome.presentation.BrandedSplashScreen
import com.genesis.feature_welcome.presentation.WelcomeScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screen.BrandedSplashScreen.route) {
        composable(Screen.BrandedSplashScreen.route) {
            BrandedSplashScreen(navController = navController)
        }
        composable(Screen.WelcomeScreen.route) {
            WelcomeScreen(onContinueClick = {
                navController.navigate(Screen.HomeScreen.route)
            })
        }
        composable(Screen.HomeScreen.route) {
            HomeScreen(navController = navController)
        }
    }
}
