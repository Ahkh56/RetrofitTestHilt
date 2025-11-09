package com.genesis.retrofittesthilt

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.genesis.core.ui.theme.RetrofitTestHiltTheme
import com.genesis.retrofittesthilt.navigation.AppNavigation
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        super.onCreate(savedInstanceState)
        setContent {
            RetrofitTestHiltTheme {
                AppNavigation()
            }
        }
    }
}
