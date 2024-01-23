package dev.bellu.messenger_clone.presentation.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.sharp.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun AddStory() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(4.dp)
    ) {
        Box(contentAlignment = Alignment.Center,
            modifier = Modifier
                .height(52.dp)
                .width(52.dp)
                .background(
                    color = MaterialTheme.colorScheme.secondary.copy(alpha = 0.08F),
                    shape = RoundedCornerShape(100)
                ),
            content = {
                Icon(
                    imageVector = Icons.Sharp.Add,
                    contentDescription = "Add",
                    modifier = Modifier
                        .height(21.dp)
                        .width(25.dp)
                )
            }
        )
        Text("Your story")
    }
}