package dev.bellu.messenger_clone.presentation.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.sharp.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import dev.bellu.messenger_clone.presentation.theme.Typography

@Composable
fun PersonStory(name: String, photo: String) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(4.dp)
    ) {
        Box(
            modifier = Modifier
                .height(52.dp)
                .width(52.dp)
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
        Text(name, style = Typography.displaySmall)
    }
}