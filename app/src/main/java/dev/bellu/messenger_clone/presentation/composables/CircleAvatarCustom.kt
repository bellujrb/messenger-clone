package dev.bellu.messenger_clone.presentation.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import dev.bellu.messenger_clone.presentation.theme.Black

@Composable
fun CircleAvatarCustom(photoUser: String, size: Dp) {
    Box(
        modifier = Modifier
            .height(size)
            .width(size)
            .clip(shape = CircleShape)
            .background(color = Black),
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