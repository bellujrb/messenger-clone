package dev.bellu.messenger_clone.presentation.screens.friends

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.bellu.messenger_clone.data.contracts.MessengerDao
import dev.bellu.messenger_clone.data.entity.ConversationEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class FriendsViewModel(private val db: MessengerDao) : ViewModel() {
    suspend fun createConversation(user1: Int, user2: Int) {
        withContext(Dispatchers.IO) {
            db.createConversation(
                ConversationEntity(
                    user1Id = user1,
                    user2Id = user2 + 1
                )
            )
        }
    }
}