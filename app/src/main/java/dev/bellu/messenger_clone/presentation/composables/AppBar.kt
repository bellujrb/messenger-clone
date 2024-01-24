package dev.bellu.messenger_clone.presentation.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Build
import androidx.compose.material.icons.outlined.Send
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import dev.bellu.messenger_clone.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppBar(title: String){
    TopAppBar(
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.background
        ),
        title = {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(
                    painter = painterResource(id = R.drawable.photo_visit),
                    contentDescription = "Photo Visit",
                    modifier = Modifier
                        .height(40.dp)
                        .width(40.dp)
                        .clip(shape = RoundedCornerShape(100))
                )
                Spacer(modifier = Modifier.width(10.dp))
                Text(title)
            }
        },
        actions = {
            CircleItem(
                icon = Icons.Outlined.Build,
                description = "Camera",
                onClick = {}
            )
            Spacer(modifier = Modifier.width(10.dp))
            CircleItem(
                icon = Icons.Outlined.Send,
                description = "Send",
                onClick = {}
            )
        }
    )
}

@Composable
private fun CircleItem(icon: ImageVector, description: String, onClick: () -> Unit) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .height(32.dp)
            .width(32.dp)
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
            contentDescription = description
        )
    }
}