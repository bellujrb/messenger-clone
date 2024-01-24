package dev.bellu.messenger_clone.presentation.screens

import android.provider.CalendarContract.Colors
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
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
import dev.bellu.messenger_clone.presentation.composables.AddStory
import dev.bellu.messenger_clone.presentation.composables.AppBar
import dev.bellu.messenger_clone.presentation.composables.InputSearch
import dev.bellu.messenger_clone.presentation.composables.PersonStory
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
                }
            }
        }
    }
}

