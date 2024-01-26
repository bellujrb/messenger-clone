package dev.bellu.messenger_clone.presentation.screens.chat

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.CameraAlt
import androidx.compose.material.icons.outlined.Mic
import androidx.compose.material.icons.outlined.Photo
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import dev.bellu.messenger_clone.presentation.theme.Blue
import dev.bellu.messenger_clone.presentation.theme.MessengerCloneTheme
import dev.bellu.messenger_clone.presentation.theme.Typography

@Composable
fun ChatScreen(navController: NavController) {

    var value by remember { mutableStateOf("") }

    MessengerCloneTheme {
        Scaffold(
            topBar = {
                AppBar(navController = navController)
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
                    Spacer(modifier = Modifier.height(10.dp))
                    Text("Sophia", style = Typography.bodyMedium)
                    Spacer(modifier = Modifier.height(5.dp))
                    Text("You are connected on Messenger", style = Typography.displayMedium)
                    LazyColumn(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier
                            .weight(1f)
                            .fillMaxWidth(),
                        content = {
                            items(1) {
                                // MSG Here!
                            }
                        }
                    )
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(60.dp)
                    ) {
                        IconsChat()
                        TextField(
                            value = value,
                            onValueChange = {
                                value = it
                            },
                            colors = TextFieldDefaults.colors(),
                            placeholder = {
                                Text(text = "Aa", style = Typography.displayMedium)
                            },
                            textStyle = Typography.displayMedium,
                            modifier = Modifier
                                .height(48.dp)
                                .fillMaxWidth(0.9f)
                                .clip(shape = RoundedCornerShape(16))
                        )
                    }
                }
            }
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun AppBar(navController: NavController){
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
}


@Composable
private fun IconsChat(){
    IconButton(
        onClick = { /*TODO*/ },
        content = {
            Icon(
                tint = Blue,
                imageVector = Icons.Outlined.CameraAlt,
                contentDescription = "Camera"
            )
        }
    )
    IconButton(
        onClick = { /*TODO*/ },
        content = {
            Icon(
                tint = Blue,
                imageVector = Icons.Outlined.Photo,
                contentDescription = "Photo"
            )
        }
    )
    IconButton(
        onClick = { /*TODO*/ },
        content = {
            Icon(
                tint = Blue,
                imageVector = Icons.Outlined.Mic,
                contentDescription = "Microphone"
            )
        }
    )
}