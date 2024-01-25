package dev.bellu.messenger_clone.presentation.screens.welcome

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import dev.bellu.messenger_clone.presentation.theme.MessengerCloneTheme
import dev.bellu.messenger_clone.R
import kotlinx.coroutines.delay

@Composable
fun WelcomeScreen(navController: NavController) {

    LaunchedEffect(key1 = null){
        delay(10)
        navController.navigate("home")
    }
    MessengerCloneTheme {
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .background(color = MaterialTheme.colorScheme.background)
        ) {
            Image(painter = painterResource(
                id = R.drawable.logo),
                contentDescription = "Messenger LOGO",
                modifier = Modifier
                    .wrapContentSize(Alignment.Center)
                    .width(276.dp)
                    .height(139.dp)
            )
        }
    }
}