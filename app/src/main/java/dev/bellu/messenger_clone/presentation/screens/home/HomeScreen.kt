package dev.bellu.messenger_clone.presentation.screens.home

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import dev.bellu.messenger_clone.presentation.theme.MessengerCloneTheme
import dev.bellu.messenger_clone.data.database.MessengerDatabase
import dev.bellu.messenger_clone.data.entity.UserEntity
import dev.bellu.messenger_clone.presentation.composables.*
import dev.bellu.messenger_clone.presentation.composables.AppBar
import dev.bellu.messenger_clone.presentation.screens.chat.ChatViewModel
import dev.bellu.messenger_clone.presentation.shared.BaseUiState
import dev.bellu.messenger_clone.presentation.shared.BaseViewModel
import dev.bellu.messenger_clone.presentation.theme.Typography
import kotlinx.coroutines.launch
import org.koin.androidx.compose.getViewModel

@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun HomeScreen(
    navController: NavController,
    viewModelBase: BaseViewModel = getViewModel(),
) {

    val uiState: State<BaseUiState> = viewModelBase.uiState.collectAsState()

    val model = uiState.value.users.getOrNull(0)?.photo ?: "Empty"

    MessengerCloneTheme {
        Scaffold(
            topBar = {
                AppBar(
                    title = "Chats",
                    model = model,
                    navController = navController
                )
            },
            containerColor = MaterialTheme.colorScheme.background,
            bottomBar = {
                BottomBarCustom(
                    navController = navController,
                    isSelected = 1
                )
            }
        ) { innerPadding ->
            Surface(
                modifier = Modifier
                    .padding(innerPadding)
                    .fillMaxSize()
                    .background(color = MaterialTheme.colorScheme.background)
            ) {
                Column(
                    modifier = Modifier.fillMaxSize()
                ) {
                    LazyRow {
                        items(uiState.value.users.size) { index ->
                            if (index > 0) {
                                PersonView(
                                    name = uiState.value.users[index].name,
                                    photo = uiState.value.users[index].photo,
                                    onClick = {
                                        viewModelBase.updateConversationIndex(index)
                                        navController.navigate("chat")
                                    }
                                )
                            }
                        }
                    }
                    Spacer(modifier = Modifier.height(10.dp))
                    LazyColumn(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier
                            .fillMaxWidth(),
                    ) {
                        if (uiState.value.users.isEmpty()) {
                            item {
                                Text(
                                    text = "No conversations available", style = Typography.headlineMedium,
                                    modifier = Modifier
                                        .padding(24.dp)
                                )
                            }
                        } else {
                            items(uiState.value.conversations.size) { index ->

                                val actualIndex = index + 1

                                ChatPreview(
                                    photo = uiState.value.users[actualIndex].photo,
                                    name = uiState.value.users[actualIndex].name,
                                    onClick = {
                                        viewModelBase.updateConversationIndex(actualIndex)
                                        navController.navigate("chat")
                                    }
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

