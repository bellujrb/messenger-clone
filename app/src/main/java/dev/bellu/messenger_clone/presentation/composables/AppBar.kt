package dev.bellu.messenger_clone.presentation.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Build
import androidx.compose.material.icons.outlined.CameraAlt
import androidx.compose.material.icons.outlined.NewLabel
import androidx.compose.material.icons.outlined.Send
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import dev.bellu.messenger_clone.presentation.theme.Typography

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppBar(title: String, model: String, navController: NavController) {

    TopAppBar(
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.background
        ),
        title = {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Box(
                    modifier = Modifier
                        .height(40.dp)
                        .width(40.dp)
                        .clickable {
                            navController.navigate("settings")
                        }
                        .clip(shape = CircleShape)
                        .background(color = MaterialTheme.colorScheme.secondary),
                    content = {
                        AsyncImage(
                            model = model,
                            contentDescription = "Person",
                            modifier = Modifier
                                .fillMaxSize()
                        )
                    }
                )
                Spacer(modifier = Modifier.width(10.dp))
                Text(title, style = Typography.bodyLarge)
            }
        },
        actions = {
            CircleItem(
                icon = Icons.Outlined.NewLabel,
                onClick = {
                    navController.navigate("friends")
                }
            )
        }
    )
}

@Composable
private fun CircleItem(icon: ImageVector, onClick: () -> Unit) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .height(40.dp)
            .width(40.dp)
            .background(
                color = MaterialTheme.colorScheme.secondary.copy(alpha = 0.08F),
                shape = RoundedCornerShape(100)
            )
            .clickable {
                onClick()
            }
    ) {
        Icon(
            imageVector = icon,
            contentDescription = "Send"
        )
    }
}