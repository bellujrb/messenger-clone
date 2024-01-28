package dev.bellu.messenger_clone.presentation.screens.settings

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import dev.bellu.messenger_clone.presentation.theme.MessengerCloneTheme
import dev.bellu.messenger_clone.R
import dev.bellu.messenger_clone.presentation.shared.BaseUiState
import dev.bellu.messenger_clone.presentation.shared.BaseViewModel
import dev.bellu.messenger_clone.presentation.theme.Typography
import org.koin.androidx.compose.getViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsScreen(
    navController: NavController,
    viewModelBase: BaseViewModel = getViewModel()
) {

    val uiStateBase: State<BaseUiState> = viewModelBase.uiState.collectAsState()
    val actualName = uiStateBase.value.users.getOrNull(0)?.name ?: "Empty"
    val model = uiStateBase.value.users.getOrNull(0)?.photo ?: "Empty"

    MessengerCloneTheme {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                        Box(
                            contentAlignment = Alignment.CenterEnd,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Text(
                                "Back",
                                modifier = Modifier
                                    .padding(8.dp)
                                    .clickable {
                                        navController.navigate("home")
                                    }
                            )
                        }
                    }
                )
            },
            content = { innerPadding ->
                Column(
                    modifier = Modifier
                        .padding(innerPadding)
                        .fillMaxSize()
                ) {
                    ProfileImage(
                        model = model,
                        actualName = actualName
                    )
                }
            }
        )
    }
}

@Composable
fun ProfileImage(model: String, actualName: String) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxWidth()
            .height(250.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CircularImageWithIcon(
                imageResource = R.drawable.circle,
                contentDescription = "Profile Image",
                model = model
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                actualName,
                style = Typography.bodyMedium
            )
        }
    }
}


@Composable
fun CircularImageWithIcon(
    imageResource: Int,
    contentDescription: String,
    model: String,
) {
    Box(
        modifier = Modifier
            .height(166.8.dp)
            .width(167.45.dp)
    ) {
        Image(
            painter = painterResource(id = imageResource),
            contentDescription = contentDescription,
            modifier = Modifier.fillMaxSize()
        )

        Box(
            modifier = Modifier
                .height(100.dp)
                .width(100.dp)
                .clip(shape = CircleShape)
                .background(color = MaterialTheme.colorScheme.secondary)
                .align(Alignment.Center),
            content = {
                AsyncImage(
                    model = model,
                    contentDescription = "Person",
                    modifier = Modifier
                        .fillMaxSize()
                )
            }
        )
    }
}