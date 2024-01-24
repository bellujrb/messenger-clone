package dev.bellu.messenger_clone.presentation.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage

@Composable
fun ChatPreview(
    photo: String,
    name: String,
    lastMessage: String,
    time: String,
    status: Boolean,
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(76.dp)
    ) {
        Row {
            Box(
                modifier = Modifier
                    .height(60.dp)
                    .width(60.dp)
                    .clip(shape = CircleShape)
                    .background(color = MaterialTheme.colorScheme.secondary),
                content = {
                    AsyncImage(
                        model = photo,
                        contentDescription = "Person",
                        modifier = Modifier
                            .fillMaxSize()
                    )
                }
            )
        }
    }
}
