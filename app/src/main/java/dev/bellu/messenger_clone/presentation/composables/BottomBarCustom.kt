package dev.bellu.messenger_clone.presentation.composables

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Message
import androidx.compose.material.icons.outlined.CompassCalibration
import androidx.compose.material.icons.outlined.PersonAddAlt
import androidx.compose.material.icons.outlined.PersonOutline
import androidx.compose.material.icons.outlined.PersonSearch
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import dev.bellu.messenger_clone.presentation.theme.Black
import dev.bellu.messenger_clone.presentation.theme.Black30
import dev.bellu.messenger_clone.presentation.theme.Blue
import dev.bellu.messenger_clone.presentation.theme.Gray

@Composable
fun BottomBarCustom(navController: NavController, isSelected: Int){
    BottomAppBar(
        containerColor = MaterialTheme.colorScheme.background,
        modifier = Modifier
            .fillMaxWidth(),
        content = {
            Spacer(modifier = Modifier.weight(1f))
            Icon(
                imageVector = Icons.AutoMirrored.Filled.Message,
                tint = if(isSelected == 1) Black else Black30,
                contentDescription = "Message",
                modifier = Modifier
                    .height(30.dp)
                    .width(30.dp)
                    .clickable {
                        navController.navigate("home")
                    }

            )
            Spacer(modifier = Modifier.weight(1f))
            Icon(
                imageVector = Icons.Outlined.PersonAddAlt,
                tint = if(isSelected == 2) Black else Black30,
                contentDescription = "Person",
                modifier = Modifier
                    .height(30.dp)
                    .width(30.dp)
                    .clickable {
                        navController.navigate("friends")
                    }
            )
            Spacer(modifier = Modifier.weight(1f))
            Icon(
                imageVector = Icons.Outlined.CompassCalibration,
                tint = if(isSelected == 3) Black else Black30,
                contentDescription = "Compass",
                modifier = Modifier
                    .height(30.dp)
                    .width(30.dp)
                    .clickable {
                        navController.navigate("advertising")
                    }
            )
            Spacer(modifier = Modifier.weight(1f))
        },
    )
}
