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
import androidx.compose.material.icons.outlined.CameraAlt
import androidx.compose.material.icons.outlined.Mic
import androidx.compose.material.icons.outlined.Photo
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import dev.bellu.messenger_clone.presentation.composables.CircleAvatarCustom
import dev.bellu.messenger_clone.presentation.composables.ReceiveMessage
import dev.bellu.messenger_clone.presentation.composables.SendMessage
import dev.bellu.messenger_clone.presentation.shared.AppState
import dev.bellu.messenger_clone.presentation.shared.BaseUiState
import dev.bellu.messenger_clone.presentation.shared.BaseViewModel
import dev.bellu.messenger_clone.presentation.theme.Black
import dev.bellu.messenger_clone.presentation.theme.Blue
import dev.bellu.messenger_clone.presentation.theme.MessengerCloneTheme
import dev.bellu.messenger_clone.presentation.theme.Typography
import kotlinx.coroutines.launch
import org.koin.androidx.compose.getViewModel

@Composable
fun ChatScreen(
    navController: NavController,
    viewModel: ChatViewModel = getViewModel(),
    viewModelBase: BaseViewModel = getViewModel(),
) {

    val uiState: State<ChatUiState> = viewModel.uiState.collectAsState()
    val uiStateBase: State<BaseUiState> = viewModelBase.uiState.collectAsState()

    val index = AppState.conversationIndex

    LaunchedEffect(key1 = index){
        viewModel.loadMessages(index)
    }

    val scope = rememberCoroutineScope()

    val actualName = uiStateBase.value.users.getOrNull(index)?.name ?: "Empty"
    val actualPhoto = uiStateBase.value.users.getOrNull(index)?.photo ?: "Empty"

    val user1 = AppState.indexMyUser
    val user2 = index + 1

    var value by remember { mutableStateOf("") }

    MessengerCloneTheme {
        Scaffold(
            topBar = {
                AppBar(
                    navController = navController,
                    nameUser = actualName,
                    photoUser = actualPhoto,
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
                            .background(color = Black),
                        content = {
                            AsyncImage(
                                model = actualPhoto,
                                contentDescription = "Person",
                                modifier = Modifier
                                    .fillMaxSize()
                            )
                        }
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        actualName,
                        style = Typography.bodyMedium
                    )
                    Spacer(modifier = Modifier.height(5.dp))
                    Text("You are connected on Messenger", style = Typography.displayMedium)
                    Spacer(modifier = Modifier.height(20.dp))
                    LazyColumn(
                        modifier = Modifier
                            .weight(1f)
                            .fillMaxWidth(0.9f),
                        content = {
                            val sortedMessages = uiState.value.messagesConversation.sortedBy { it.timestamp }

                            items(sortedMessages.size) { index ->

                                val senderId: Int = uiState.value.messagesConversation[index].senderId

                                if (user1 == senderId) {
                                    Box(
                                        modifier = Modifier.fillMaxWidth(),
                                        contentAlignment = Alignment.CenterEnd
                                    ) {
                                        SendMessage(text = uiState.value.messagesConversation[index].content)
                                    }
                                }

                                if (user2 == senderId) {
                                    Row(verticalAlignment = Alignment.CenterVertically) {
                                        CircleAvatarCustom(
                                            photoUser = actualPhoto,
                                            size = 40.dp
                                        )
                                        Spacer(modifier = Modifier.width(10.dp))
                                        ReceiveMessage(text = uiState.value.messagesConversation[index].content)
                                    }
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
                            onClick = {
                                scope.launch {
                                    viewModel.sendMessage(
                                        senderId = index,
                                        conversationId = index,
                                        content = value
                                    )

                                    value = ""
                                }
                            },
                            content = {
                                Icon(
                                    tint = Blue,
                                    imageVector = Icons.AutoMirrored.Outlined.Send,
                                    contentDescription = "Send"
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
private fun AppBar(
    nameUser: String,
    navController: NavController,
    photoUser: String,
) {
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
                CircleAvatarCustom(photoUser = photoUser, size = 40.dp)
                Spacer(modifier = Modifier.width(10.dp))
                Column {
                    Text(nameUser, style = Typography.headlineMedium)
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