package dev.bellu.messenger_clone.presentation.composables

import androidx.compose.animation.core.Animatable
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import dev.bellu.messenger_clone.R
import dev.bellu.messenger_clone.presentation.theme.Typography
import kotlin.math.roundToInt

@Composable
fun ChatPreview(
    photo: String,
    name: String,
    lastMessageIsYou: Boolean,
    lastMessage: String,
    time: String,
    status: Boolean,
) {

    var offsetX by remember { mutableFloatStateOf(0f) }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(76.dp)
            .offset { IntOffset(offsetX.roundToInt(), 0) }
            .draggable(
                orientation = Orientation.Horizontal,
                state = rememberDraggableState { delta ->
                    offsetX += delta
                }
            ),
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
            .fillMaxWidth()
                .padding(
                    end = 20.dp,
                    start = 20.dp
                )
        ) {
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

            Column {
                Text(name, style = Typography.headlineMedium)
                Row {
                    Text(
                        "" +
                                "${
                                    if (lastMessageIsYou)
                                        "You:" else "$name:"
                                } " +
                                "$lastMessage · ", style = Typography.displayMedium
                    )
                    Text("$time AM", style = Typography.displayMedium)
                }
            }

            Spacer(modifier = Modifier.width(32.dp))
            if (status) {
                Image(
                    painter = painterResource(id = R.drawable.read),
                    contentDescription = "Read"
                )
            } else {
                Image(
                    painter = painterResource(id = R.drawable.noread),
                    contentDescription = "NO Read"
                )
            }
        }
    }
}
