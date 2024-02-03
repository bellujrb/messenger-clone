package dev.bellu.messenger_clone.presentation.screens.advertising

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import dev.bellu.messenger_clone.presentation.composables.AppBar
import dev.bellu.messenger_clone.presentation.composables.BottomBarCustom
import dev.bellu.messenger_clone.presentation.shared.BaseUiState
import dev.bellu.messenger_clone.presentation.shared.BaseViewModel
import dev.bellu.messenger_clone.presentation.theme.Blue
import dev.bellu.messenger_clone.presentation.theme.Gray
import dev.bellu.messenger_clone.presentation.theme.Typography
import org.koin.androidx.compose.getViewModel

@Composable
fun AdvertisingScreen(
    navController: NavController,
    baseViewModel: BaseViewModel = getViewModel(),
    advertisingViewModel: AdvertisingViewModel = getViewModel(),
) {

    val uiState: State<BaseUiState> = baseViewModel.uiState.collectAsState()

    Scaffold(
        topBar = {
            AppBar(
                title = "Advertising",
                model = "",
                navController = navController
            )
        },
        bottomBar = {
            BottomBarCustom(
                navController = navController,
                isSelected = 3
            )
        },
        content = { innerPadding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
            ) {
                Spacer(modifier = Modifier.height(10.dp))
                LazyColumn(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .fillMaxSize(),
                    content = {
                        if (uiState.value.users.isEmpty()) {
                            item {
                                Text(
                                    text = "No advertising available", style = Typography.headlineMedium,
                                    modifier = Modifier
                                        .padding(24.dp)
                                )
                            }
                        } else {
                            items(uiState.value.advertising.size) { index ->
                                AdvertisingComponent(
                                    model = uiState.value.advertising[index].photo,
                                    title = uiState.value.advertising[index].name,
                                    subtitle = uiState.value.advertising[index].subtitle
                                )
                            }
                        }
                    }
                )
            }
        }
    )
}

@Composable
private fun AdvertisingComponent(model: String, title: String, subtitle: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth(0.95f)
            .height(100.dp)
    ) {
        AsyncImage(
            model = model,
            contentDescription = "Advertising",
            modifier = Modifier
                .height(60.dp)
                .width(60.dp)
                .background(color = Gray)
        )
        Spacer(modifier = Modifier.width(10.dp))
        Column(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Text(title, style = Typography.headlineMedium)
            Text(subtitle, style = Typography.displayMedium)
        }
    }
}
