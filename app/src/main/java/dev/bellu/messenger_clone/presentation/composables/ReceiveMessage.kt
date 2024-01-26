package dev.bellu.messenger_clone.presentation.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dev.bellu.messenger_clone.presentation.theme.Black
import dev.bellu.messenger_clone.presentation.theme.Typography

@Composable
fun ReceiveMessage(text: String) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .padding(
                top = 2.dp,
                bottom = 2.dp
            )
            .background(
                color = Black.copy(alpha = 0.06f), shape = RoundedCornerShape(
                    topEnd = 18.dp,
                    topStart = 18.dp,
                    bottomEnd = 18.dp,
                    bottomStart = 4.dp
                )
            )
            .heightIn(min = 36.dp)
    ) {
        Text(
            text, style = Typography.headlineSmall,
            modifier = Modifier
                .padding(12.dp)
        )
    }
}
