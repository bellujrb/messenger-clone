package dev.bellu.messenger_clone.presentation.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import dev.bellu.messenger_clone.presentation.theme.Black
import dev.bellu.messenger_clone.presentation.theme.Typography

@Composable
fun PersonView(name: String, photo: String, onClick: () -> Unit) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(4.dp)
    ) {
        Box(
            modifier = Modifier
                .clickable { onClick() }
                .height(52.dp)
                .width(52.dp)
                .clip(shape = CircleShape)
                .background(color = Black),
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