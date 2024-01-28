package dev.bellu.messenger_clone.presentation.screens.chat

data class ChatUiState(
    val currentMessage: Int = 1,
    val messageSender: List<String> = listOf(""),
    val messageReceiver: List<String> = listOf(""),
)