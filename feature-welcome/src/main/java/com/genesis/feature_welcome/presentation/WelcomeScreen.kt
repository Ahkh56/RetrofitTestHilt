package com.genesis.feature_welcome.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.genesis.core.R
import com.genesis.core.ui.theme.RetrofitTestHiltTheme


@Composable
fun WelcomeScreen(onContinueClick: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(15.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.welcome_png),
            contentDescription = null,
            contentScale = ContentScale.Fit,
            modifier = Modifier.height(dimensionResource(id = com.intuit.sdp.R.dimen._120sdp))
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "Welcome to Retrofit",
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = onContinueClick) {
            Text(text = "Continue")
        }
    }
}

@Preview(showBackground = true, showSystemUi = true, device = "spec:width=2340px,height=1080px,dpi=440,orientation=portrait")
@Composable
fun WelcomeScreenPreview() {
    RetrofitTestHiltTheme {
        WelcomeScreen(onContinueClick = {})
    }
}
