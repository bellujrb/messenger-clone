package dev.bellu.messenger_clone.presentation.screens.chat

import dev.bellu.messenger_clone.data.entity.MessageEntity

data class ChatUiState(
    val ownerChat: Int = 1,
    val userChat: Int = 2,
    val currentMessage: Int = 1,
    val messages: List<MessageEntity> = listOf()
)