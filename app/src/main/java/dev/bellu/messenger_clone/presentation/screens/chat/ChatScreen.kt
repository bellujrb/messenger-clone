package dev.bellu.messenger_clone.presentation.screens.chat

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import dev.bellu.messenger_clone.presentation.theme.Blue
import dev.bellu.messenger_clone.presentation.theme.MessengerCloneTheme
import dev.bellu.messenger_clone.presentation.theme.Typography

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChatScreen(navController: NavController) {
    MessengerCloneTheme {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            IconButton(
                                onClick = { navController.navigate("home") },
                                content = {
                                    Icon(
                                        tint = Blue,
                                        imageVector = Icons.Default.ArrowBackIosNew,
                                        contentDescription = "Back",
                                        modifier = Modifier
                                            .height(25.dp)
                                            .width(25.dp)
                                    )
                                }
                            )
                            Spacer(modifier = Modifier.width(5.dp))
                            Box(
                                modifier = Modifier
                                    .height(40.dp)
                                    .width(40.dp)
                                    .clip(shape = CircleShape)
                                    .background(color = MaterialTheme.colorScheme.secondary),
                                content = {
                                    AsyncImage(
                                        model = "",
                                        contentDescription = "Person",
                                        modifier = Modifier
                                            .fillMaxSize()
                                    )
                                }
                            )
                            Spacer(modifier = Modifier.width(10.dp))
                            Column {
                                Text("Sophia", style = Typography.headlineMedium)
                                Row {
                                    Text(
                                        "Messenger", style = Typography.displayMedium
                                    )
                                }
                            }
                        }
                    }
                )
            },
            content = { innerPadding ->
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .padding(innerPadding)
                        .fillMaxSize()
                ) {
                    Box(
                        modifier = Modifier
                            .height(100.dp)
                            .width(100.dp)
                            .clip(shape = CircleShape)
                            .background(color = MaterialTheme.colorScheme.secondary),
                        content = {
                            AsyncImage(
                                model = "",
                                contentDescription = "Person",
                                modifier = Modifier
                                    .fillMaxSize()
                            )
                        }
                    )
                }
            }
        )
    }
}