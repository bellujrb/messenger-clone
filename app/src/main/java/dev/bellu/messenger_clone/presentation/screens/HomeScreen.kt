package dev.bellu.messenger_clone.presentation.screens

import android.provider.CalendarContract.Colors
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.outlined.Send
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.DefaultTintColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewModelScope
import dev.bellu.messenger_clone.presentation.theme.MessengerCloneTheme
import dev.bellu.messenger_clone.R
import dev.bellu.messenger_clone.data.database.MessengerDatabase
import dev.bellu.messenger_clone.presentation.composables.*
import dev.bellu.messenger_clone.presentation.viewmodel.HomeViewModel
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(viewModel: HomeViewModel = HomeViewModel(
    db = MessengerDatabase.getDatabase(
        LocalContext.current
    )
)
) {

    val uiState: State<HomeUiState> = viewModel.uiState.collectAsState()

    MessengerCloneTheme {
        Scaffold(
            topBar = {
                AppBar(
                    title = "Chats"
                )
            },
            containerColor = MaterialTheme.colorScheme.background
        ) { innerPadding ->
            Surface(
                modifier = Modifier
                    .padding(innerPadding)
                    .fillMaxSize()
                    .background(color = MaterialTheme.colorScheme.background)
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.fillMaxSize()
                ) {
                    Spacer(modifier = Modifier.height(10.dp))
                    InputSearch()
                    Spacer(modifier = Modifier.height(10.dp))
                    Row {
                        AddStory()
                        LazyRow(
                            modifier = Modifier
                                .height(100.dp)
                        ) {
                            items(uiState.value.users.size) {index ->
                                PersonStory(
                                    name = uiState.value.users[index].name,
                                    photo = uiState.value.users[index].photo
                                )
                            }
                        }
                    }
                    Spacer(modifier = Modifier.height(10.dp))
                    LazyColumn{
                        items(1){
                            ChatPreview(
                                photo = "https://images.unsplash.com/photo-1635488640163-e5f6782cda6e?q=80&w=1888&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
                                name = "Elena",
                                lastMessageIsYou = true,
                                lastMessage = "What’s man!",
                                time = "9:40",
                                status = true
                            )
                        }
                    }
                }
            }
        }
    }
}

