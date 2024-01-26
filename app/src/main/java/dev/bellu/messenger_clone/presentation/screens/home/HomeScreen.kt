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
import dev.bellu.messenger_clone.presentation.composables.*
import dev.bellu.messenger_clone.presentation.composables.AppBar
import kotlinx.coroutines.launch

@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun HomeScreen(
    navController: NavController,
    viewModel: HomeViewModel = HomeViewModel(
        db = MessengerDatabase.getDatabase(
            LocalContext.current
        )
    ),
) {

    val uiState: State<HomeUiState> = viewModel.uiState.collectAsState()
    val scope = rememberCoroutineScope()

    scope.launch {
        viewModel.fetchDatabase()
    }

    MessengerCloneTheme {
        Scaffold(
            topBar = {
                AppBar(
                    title = "Chats",
                )
            },
            containerColor = MaterialTheme.colorScheme.background,
            bottomBar = { BottomBarCustom() }
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
                    Spacer(modifier = Modifier.height(10.dp))
                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        InputSearch()
                    }
                    Spacer(modifier = Modifier.height(10.dp))
                    Row {
                        AddStory()
                        LazyRow(
                            modifier = Modifier
                                .height(100.dp)
                        ) {
                            items(uiState.value.users.size) { index ->
                                if (index > 0) {
                                    PersonStory(
                                        name = uiState.value.users[index].name,
                                        photo = uiState.value.users[index].photo
                                    )
                                }
                            }
                        }
                    }
                    Spacer(modifier = Modifier.height(10.dp))
                    LazyColumn {
                        items(uiState.value.users.size) { index ->
                            ChatPreview(
                                photo = uiState.value.users[index].photo,
                                name = uiState.value.users[index].name,
                                lastMessageIsYou = true,
                                lastMessage = "What’s man!",
                                time = "9:40",
                                status = true,
                                onClick = {
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

