package dev.bellu.messenger_clone.presentation.screens.friends

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import dev.bellu.messenger_clone.presentation.composables.AppBar
import dev.bellu.messenger_clone.presentation.composables.BottomBarCustom
import dev.bellu.messenger_clone.presentation.composables.CircleAvatarCustom
import dev.bellu.messenger_clone.presentation.composables.InputSearch
import dev.bellu.messenger_clone.presentation.shared.BaseUiState
import dev.bellu.messenger_clone.presentation.shared.BaseViewModel
import dev.bellu.messenger_clone.presentation.theme.Black30
import dev.bellu.messenger_clone.presentation.theme.Green
import dev.bellu.messenger_clone.presentation.theme.Typography
import kotlinx.coroutines.launch
import org.koin.androidx.compose.getViewModel

@Composable
fun FriendsScreen(
    navController: NavController,
    viewModel: FriendsViewModel = getViewModel(),
    viewModelBase: BaseViewModel = getViewModel()
) {

    val uiStateBase: State<BaseUiState> = viewModelBase.uiState.collectAsState()
    val actualPhoto = uiStateBase.value.users.getOrNull(0)?.photo ?: "Empty"

    val scope = rememberCoroutineScope()

    Scaffold(
        topBar = {
            AppBar(
                title = "Friends",
                model = actualPhoto,
                navController = navController
            )
        },
        bottomBar = {
            BottomBarCustom(navController)
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
        ) {
            Spacer(modifier = Modifier.height(10.dp))
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.fillMaxWidth()
            ) {
                InputSearch()
            }
            Spacer(modifier = Modifier.height(10.dp))
            LazyColumn {
                items(uiStateBase.value.users.size) { index ->
                    if (index > 0) {
                        FriendComponent(
                            photoUser = uiStateBase.value.users[index].photo,
                            nameUser = uiStateBase.value.users[index].name,
                            status = uiStateBase.value.users[index].status,
                            onClick = {
                                scope.launch {
                                    viewModel.createConversation(
                                        user1 = 1,
                                        user2 = index,
                                    )
                                }
                            }
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun FriendComponent(photoUser: String, nameUser: String, status: Boolean, onClick: () -> Unit) {
    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(
            top = 5.dp,
            bottom = 5.dp,
            start = 20.dp,
            end = 20.dp
        )
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .clickable {
                    onClick()
                }
        ) {
            Column {
                CircleAvatarCustom(
                    photoUser = photoUser,
                    size = 40.dp
                )
                if(status){
                    Box(modifier = Modifier
                        .height(10.dp)
                        .width(10.dp)
                        .offset(
                            y = (-10).dp,
                            x = 30.dp
                        )
                        .background(color = Green, shape = RoundedCornerShape(100))
                    )
                } else {
                    Spacer(modifier = Modifier
                        .height(10.dp)
                        .width(10.dp))
                }
            }
            Spacer(modifier = Modifier.width(10.dp))
            Text(nameUser, style = Typography.headlineSmall)
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = Black30.copy(alpha = 0.1f))
                .height(2.dp)
        )
    }
}