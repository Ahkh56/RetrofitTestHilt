package com.genesis.core.navigation

sealed class Screen(val route: String) {
    object BrandedSplashScreen : Screen("branded_splash")
    object WelcomeScreen : Screen("welcome")
    object HomeScreen : Screen("home_screen")
}
