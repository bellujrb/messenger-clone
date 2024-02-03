package dev.bellu.messenger_clone.presentation.screens.chat

import dev.bellu.messenger_clone.data.entity.MessageEntity

data class ChatUiState(
    val user1: Int = 0,
    val user2: Int = 0,
    val currentConversation: Int = 0,
    val messages: List<MessageEntity> = listOf(),
    val messagesConversation: List<MessageEntity> = listOf()
)