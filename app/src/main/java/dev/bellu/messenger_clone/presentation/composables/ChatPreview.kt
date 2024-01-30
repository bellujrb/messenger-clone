package dev.bellu.messenger_clone.presentation.composables

import androidx.compose.animation.core.Animatable
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Build
import androidx.compose.material.icons.outlined.Clear
import androidx.compose.material.icons.outlined.Send
import androidx.compose.material.icons.outlined.SettingsCell
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import dev.bellu.messenger_clone.R
import dev.bellu.messenger_clone.presentation.theme.Black
import dev.bellu.messenger_clone.presentation.theme.Typography
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.math.roundToInt

@Composable
fun ChatPreview(
    photo: String,
    name: String,
    lastMessageIsYou: Boolean,
    lastMessage: String,
    time: String,
    status: Boolean,
    onClick: () -> Unit
) {

    var offsetX by remember { mutableFloatStateOf(0f) }
    val minOffsetX = 0f
    val maxOffsetX =  100f

    val scope = rememberCoroutineScope()

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(76.dp)
            .clickable { onClick() }
            .offset { IntOffset(offsetX.roundToInt(), 0) }
            .draggable(
                orientation = Orientation.Horizontal,
                state = rememberDraggableState { delta ->
                    offsetX = (offsetX + delta).coerceIn(minOffsetX, maxOffsetX)
                },
                onDragStopped = {
                    scope.launch {
                        delay(5000)
                        offsetX = 0f
                    }
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
            if(offsetX > 0){
                CircleItem(
                    icon = Icons.Outlined.Build,
                    description = "Camera",
                    onClick = {}
                )
                Spacer(modifier = Modifier.width(10.dp))
                CircleItem(
                    icon = Icons.Outlined.SettingsCell,
                    description = "Ligar",
                    onClick = {}
                )
                Spacer(modifier = Modifier.width(10.dp))
                CircleItem(
                    icon = Icons.Outlined.Clear,
                    description = "Apagar",
                    onClick = {}
                )
            }
            Box(
                modifier = Modifier
                    .height(60.dp)
                    .width(60.dp)
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

@Composable
private fun CircleItem(icon: ImageVector, description: String, onClick: () -> Unit) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .padding(
                end = 12.dp,
            )
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