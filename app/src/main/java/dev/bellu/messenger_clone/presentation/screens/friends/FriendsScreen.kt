package dev.bellu.messenger_clone.presentation.screens.friends

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import dev.bellu.messenger_clone.presentation.composables.AppBar
import dev.bellu.messenger_clone.presentation.composables.InputSearch

@Composable
fun FriendsScreen(navController: NavController){
    Scaffold(
        topBar = {
            AppBar(
                title = "Friends",
                model = "",
                navController = navController
            )
        },
        content = { innerPadding ->
            Column(modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()) {
                Spacer(modifier = Modifier.height(10.dp))
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    InputSearch()
                }
                Spacer(modifier = Modifier.height(10.dp))
            }
        }
    )
}