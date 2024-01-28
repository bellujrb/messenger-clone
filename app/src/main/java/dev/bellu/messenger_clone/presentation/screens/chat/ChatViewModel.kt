package dev.bellu.messenger_clone.presentation.screens.chat

import androidx.lifecycle.ViewModel
import dev.bellu.messenger_clone.data.contracts.MessengerDao
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class ChatViewModel(private val db: MessengerDao): ViewModel() {

    private val _uiState = MutableStateFlow(ChatUiState())
    val uiState: StateFlow<ChatUiState> = _uiState.asStateFlow()

    val messages: List<String> = listOf(
        "Hello, Jacob!",
        "How are you doing?"
    )

    val messagesTwo: List<String> = listOf(
        "Hello!",
        "I'm very good"
    )
}