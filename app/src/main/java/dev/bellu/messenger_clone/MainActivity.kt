package dev.bellu.messenger_clone

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Text
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dev.bellu.messenger_clone.presentation.screens.chat.ChatScreen
import dev.bellu.messenger_clone.presentation.screens.home.HomeScreen
import dev.bellu.messenger_clone.presentation.screens.home.HomeUiState
import dev.bellu.messenger_clone.presentation.screens.home.HomeViewModel
import dev.bellu.messenger_clone.presentation.screens.welcome.WelcomeScreen
import org.koin.androidx.compose.getViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            AppNavGraph(navController)
        }
    }
}