package dev.bellu.messenger_clone.presentation.screens.chat

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.bellu.messenger_clone.data.contracts.MessengerDao
import dev.bellu.messenger_clone.data.entity.MessageEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ChatViewModel(private val db: MessengerDao) : ViewModel() {

    private val _uiState = MutableStateFlow(ChatUiState())
    val uiState: StateFlow<ChatUiState> = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            generateMessages()
        }
    }

    suspend fun sendMessage(senderId: Int, receiverId: Int, content: String) {
        val sendMessage = MessageEntity(
            senderId = senderId,
            receiverId = receiverId,
            content = content,
            timestamp = System.currentTimeMillis()
        )

        withContext(Dispatchers.IO) {
            db.sendMessage(sendMessage)

            val messagesFromDb = db.getAllMessages()

            _uiState.value = _uiState.value.copy(
                messages = messagesFromDb
            )
        }
    }

    private suspend fun generateMessages() {
        withContext(Dispatchers.IO) {
            val messagesFromDb = db.getAllMessages()

            _uiState.value = _uiState.value.copy(
                messages = messagesFromDb
            )
        }

        Log.e("Messages", _uiState.value.messages.toString())
    }
}

