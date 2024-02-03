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

    suspend fun loadMessages(conversationId: Int) {
        val contentList = mutableListOf<MessageEntity>()

        val conversationMessages = _uiState.value.messages.filter { filter ->
            filter.conversationId == conversationId
        }

        conversationMessages.forEach { message ->
            val id = message.id
            val senderId = message.senderId
            val content = message.content
            val timestamp = message.timestamp
            contentList.add(
                MessageEntity(
                    id = id,
                    senderId = senderId,
                    content = content,
                    conversationId = conversationId,
                    timestamp = timestamp
                )
            )
        }

        withContext(Dispatchers.IO){
            _uiState.value = _uiState.value.copy(
                messagesConversation = contentList
            )
        }

        Log.e("loadMessage", _uiState.value.messagesConversation.toString())
    }

    suspend fun sendMessage(senderId: Int, conversationId: Int, content: String) {
        val sendMessage = MessageEntity(
            senderId = senderId,
            conversationId = conversationId,
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

