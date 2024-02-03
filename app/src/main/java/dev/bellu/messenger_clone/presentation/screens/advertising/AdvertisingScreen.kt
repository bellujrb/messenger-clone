package dev.bellu.messenger_clone.presentation.screens.advertising

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import dev.bellu.messenger_clone.presentation.composables.AppBar
import dev.bellu.messenger_clone.presentation.composables.BottomBarCustom
import dev.bellu.messenger_clone.presentation.composables.InputSearch

@Composable
fun AdvertisingScreen(navController: NavController) {
    Scaffold(
        topBar = {
            AppBar(
                title = "Advertising",
                model = "",
                navController = navController
            )
        },
        bottomBar = {
            BottomBarCustom(
                navController = navController,
                isSelected = 3
            )
        },
        content = { innerPadding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
            ) {
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