package com.genesis.feature_welcome.presentation

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.genesis.retrofittesthilt.MainActivity
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Instrumented test for the BrandedSplashScreen.
 * This test launches MainActivity and checks the behavior of the splash screen.
 */
@HiltAndroidTest
@RunWith(AndroidJUnit4::class)
class BrandedSplashScreenTest {

    @get:Rule(order = 0)
    val hiltRule = HiltAndroidRule(this)

    // Use createAndroidComposeRule to launch a specific activity for the test.
    @get:Rule(order = 1)
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun splashScreen_displaysContentAndNavigatesAfterDelay() {
        // The Activity is already launched by the rule, so we don't need setContent.

        // 1. Verify that the initial UI content from BrandedSplashScreen is displayed.
        composeTestRule.onNodeWithContentDescription("App Logo").assertIsDisplayed()
        composeTestRule.onNodeWithText("Genesis Dev").assertIsDisplayed()

        // 2. Fast-forward the clock just past the delay to trigger navigation.
        // We advance by 2100 milliseconds to be safely past the 2000ms delay.
        composeTestRule.mainClock.advanceTimeBy(2100)

        // 3. Verify that the WelcomeScreen is now displayed.
        // This confirms that navigation has occurred.
        composeTestRule.onNodeWithText("Welcome Screen").assertIsDisplayed()
    }
}
