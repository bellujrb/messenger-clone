package dev.bellu.messenger_clone.presentation.screens.note

import android.widget.Space
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material.icons.filled.Cancel
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import dev.bellu.messenger_clone.presentation.shared.BaseUiState
import dev.bellu.messenger_clone.presentation.shared.BaseViewModel
import dev.bellu.messenger_clone.presentation.theme.Blue
import dev.bellu.messenger_clone.presentation.theme.MessengerCloneTheme
import dev.bellu.messenger_clone.presentation.theme.Typography
import dev.bellu.messenger_clone.presentation.theme.White
import org.koin.androidx.compose.getViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NoteScreen(
    navController: NavController,
    baseViewModel: BaseViewModel = getViewModel(),
) {

    val uiState: State<BaseUiState> = baseViewModel.uiState.collectAsState()
    val actualPhoto = uiState.value.users.getOrNull(0)?.photo ?: "Empty"

    MessengerCloneTheme {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceAround,
                            modifier = Modifier
                                .fillMaxWidth()
                        ) {
                            IconButton(onClick = { navController.navigate("home") }) {
                                Icon(
                                    imageVector = Icons.Filled.ArrowBackIosNew,
                                    contentDescription = "Cancel",
                                    tint = Blue
                                )
                            }
                            Text("New note", style = Typography.headlineSmall)
                            IconButton(onClick = { /*TODO*/ }) {
                                Icon(
                                    imageVector = Icons.Filled.Share,
                                    contentDescription = "Share",
                                    tint = Blue
                                )
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
                        contentAlignment = Alignment.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(281.dp)
                    ) {
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            CircleAvatarCustomWithInput(photoUser = actualPhoto)
                            Spacer(modifier = Modifier.height(10.dp))
                            Text("0/60", style = Typography.displaySmall)
                        }
                    }
                    Box(
                        contentAlignment = Alignment.BottomEnd,
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(24.dp)
                    ) {
                        Text(
                            "Friends can see your note for 24 hrs. People won't get a notification when you share.",
                            style = Typography.displaySmall,
                            textAlign = TextAlign.Center,
                        )
                    }
                }
            }
        )
    }
}

@Composable
private fun CircleAvatarCustomWithInput(photoUser: String) {

    var text by remember { mutableStateOf("") }

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Box(
            modifier = Modifier
                .height(83.dp)
                .width(201.dp)
                .background(
                    color = Blue.copy(
                        alpha = 0.8f
                    ), shape = RoundedCornerShape(12.dp)
                )
        ) {
            TextField(
                value = text,
                onValueChange = { newValue ->
                    text = newValue
                },
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Blue.copy(alpha = 0.8f),
                    unfocusedContainerColor = Blue.copy(alpha = 0.8f),
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                ),
                textStyle = Typography.labelMedium,
                modifier = Modifier
                    .fillMaxSize(),
                maxLines = 60
            )
        }

        Spacer(modifier = Modifier.height(5.dp))

        Row {
            Box(
                modifier = Modifier
                    .height(12.dp)
                    .width(12.dp)
                    .background(color = Blue, shape = RoundedCornerShape(100))
            )

            Spacer(modifier = Modifier.width(88.dp))
        }

        Spacer(modifier = Modifier.height(5.dp))

        Row {
            Box(
                modifier = Modifier
                    .height(12.dp)
                    .width(12.dp)
                    .background(color = Blue, shape = RoundedCornerShape(100))
            )

            Spacer(modifier = Modifier.width(72.dp))
        }

        Box(
            modifier = Modifier
                .height(100.dp)
                .width(100.dp)
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
}