package dev.bellu.messenger_clone

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.NavHost
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navOptions
import dev.bellu.messenger_clone.presentation.screens.HomeScreen
import dev.bellu.messenger_clone.presentation.screens.WelcomeScreen
import dev.bellu.messenger_clone.presentation.theme.MessengerCloneTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()

            NavHost(navController = navController, startDestination = "welcome"){
                composable("welcome") { WelcomeScreen(navController) }
                composable("home") { HomeScreen() }
            }
        }
    }
}