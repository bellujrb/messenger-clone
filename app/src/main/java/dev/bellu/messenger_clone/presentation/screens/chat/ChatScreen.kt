package dev.bellu.messenger_clone.presentation.screens.chat

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.Send
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.CameraAlt
import androidx.compose.material.icons.outlined.Mic
import androidx.compose.material.icons.outlined.Photo
import androidx.compose.material.icons.outlined.Send
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import dev.bellu.messenger_clone.data.database.MessengerDatabase
import dev.bellu.messenger_clone.presentation.composables.ReceiveMessage
import dev.bellu.messenger_clone.presentation.composables.SendMessage
import dev.bellu.messenger_clone.presentation.screens.home.HomeUiState
import dev.bellu.messenger_clone.presentation.screens.home.HomeViewModel
import dev.bellu.messenger_clone.presentation.theme.Blue
import dev.bellu.messenger_clone.presentation.theme.MessengerCloneTheme
import dev.bellu.messenger_clone.presentation.theme.Typography
import org.koin.androidx.compose.getViewModel

@Composable
fun ChatScreen(
    navController: NavController,
    viewModel: ChatViewModel = getViewModel(),
) {

    var value by remember { mutableStateOf("") }

    MessengerCloneTheme {
        Scaffold(
            topBar = {
                AppBar(
                    navController = navController,
                    photoUser = viewModel.img
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
                                model = viewModel.img,
                                contentDescription = "Person",
                                modifier = Modifier
                                    .fillMaxSize()
                            )
                        }
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Text("", style = Typography.bodyMedium)
                    Spacer(modifier = Modifier.height(5.dp))
                    Text("You are connected on Messenger", style = Typography.displayMedium)
                    Spacer(modifier = Modifier.height(20.dp))
                    LazyColumn(
                        modifier = Modifier
                            .weight(1f)
                            .fillMaxWidth(0.9f),
                        content = {

                            val lastNumber = viewModel.messages.indexOfLast { true }

                            items(viewModel.messages.size - 1) { index ->
                                Row {
                                    Spacer(modifier = Modifier.width(50.dp))
                                    ReceiveMessage(text = viewModel.messages[index])
                                }
                                if (index + 1 == lastNumber) {
                                    Row(verticalAlignment = Alignment.CenterVertically) {
                                        CircleAvatarCustom(
                                            photoUser = viewModel.img
                                        )
                                        Spacer(modifier = Modifier.width(10.dp))
                                        ReceiveMessage(text = viewModel.messages[lastNumber])
                                    }
                                }
                            }

                            item {
                                Spacer(modifier = Modifier.height(10.dp))
                            }

                            items(viewModel.messagesTwo.size) { index ->
                                Box(
                                    modifier = Modifier
                                        .fillMaxSize()
                                        .align(Alignment.End)
                                ) {
                                    SendMessage(text = viewModel.messagesTwo[index])
                                }
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
                                .fillMaxWidth(0.8f)
                                .clip(shape = RoundedCornerShape(16))
                        )
                        Spacer(modifier = Modifier.width(5.dp))
                        IconButton(
                            onClick = { /*TODO*/ },
                            content = {
                                Icon(
                                    tint = Blue,
                                    imageVector = Icons.AutoMirrored.Outlined.Send,
                                    contentDescription = "Camera"
                                )
                            }
                        )
                    }
                }
            }
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun AppBar(navController: NavController, photoUser: String) {
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
                CircleAvatarCustom(photoUser = photoUser)
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
private fun CircleAvatarCustom(photoUser: String) {
    Box(
        modifier = Modifier
            .height(40.dp)
            .width(40.dp)
            .clip(shape = CircleShape)
            .background(color = MaterialTheme.colorScheme.secondary),
        content = {
            AsyncImage(
                model = photoUser,
                contentDescription = "Person",
                modifier = Modifier
                    .fillMaxSize()
            )
        }
    )
}

@Composable
private fun IconsChat() {
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