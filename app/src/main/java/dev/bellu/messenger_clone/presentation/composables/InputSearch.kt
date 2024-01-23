package dev.bellu.messenger_clone.presentation.composables

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp

@Composable
fun InputSearch() {

    var value by remember { mutableStateOf("") }

    TextField(
        value = value,
        onValueChange = {
            value = it
        },
        colors = TextFieldDefaults.colors(),
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = "Search"
            )
        },
        placeholder = {
            Text(text = "Search")
        },
        modifier = Modifier
            .fillMaxWidth(0.9f)
            .clip(shape = RoundedCornerShape(16))
    )
}