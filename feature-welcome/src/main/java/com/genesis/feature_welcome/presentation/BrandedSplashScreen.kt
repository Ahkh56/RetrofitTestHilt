package com.genesis.feature_welcome.presentation

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.intuit.sdp.R as Rsdp
import com.intuit.ssp.R as Rssp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.genesis.core.R
import com.genesis.core.navigation.Screen
import com.genesis.core.ui.theme.RetrofitTestHiltTheme
import kotlinx.coroutines.delay

/**
 * The "smart" composable that handles navigation logic.
 */
@Composable
fun BrandedSplashScreen(navController: NavController) {
    // This effect will run once, wait 2 seconds, then navigate.
    LaunchedEffect(key1 = true) {
        delay(2000) // 2-second delay
        navController.navigate(Screen.WelcomeScreen.route) {
            // Remove the splash screen from the back stack
            popUpTo(Screen.BrandedSplashScreen.route) { inclusive = true }
        }
    }

    // Display the UI
    BrandedSplashContent()
}

/**
 * The "dumb" composable that only contains the UI and is easy to preview.
 */
@Composable
private fun BrandedSplashContent() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Your custom picture from the :core module
        Image(
            modifier = Modifier.height(dimensionResource(id = Rsdp.dimen._100sdp)),
            painter = painterResource(id = R.drawable.retrofit_png),
            contentDescription = "App Logo",
            contentScale = ContentScale.Fit
        )

        Spacer(modifier = Modifier.height(25.dp))

        // Your custom text
        Text(text = "Genesis Dev", fontSize = 25.sp)
    }
}

@Preview(name = "Small Device", showBackground = true, showSystemUi = true, device = "id:pixel_5", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun BrandedSplashScreenDeviceSmall() {
    RetrofitTestHiltTheme {
        Surface(modifier = Modifier.fillMaxSize()) {
            BrandedSplashContent()
        }
    }
}
