package dev.bellu.messenger_clone

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dev.bellu.messenger_clone.presentation.screens.chat.ChatScreen
import dev.bellu.messenger_clone.presentation.screens.home.HomeScreen
import dev.bellu.messenger_clone.presentation.screens.settings.SettingsScreen
import dev.bellu.messenger_clone.presentation.screens.welcome.WelcomeScreen

@Composable
fun AppNavGraph(
    navController: NavHostController,
    startDestination: String = "home"
){

    NavHost(
        navController = navController,
        startDestination = startDestination
    ){
        composable("welcome"){ WelcomeScreen(navController)}
        composable("home"){ HomeScreen(navController)}
        composable("chat"){ ChatScreen(navController)}
        composable("settings") { SettingsScreen(navController) }
    }
}