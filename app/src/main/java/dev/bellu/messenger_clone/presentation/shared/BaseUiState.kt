package dev.bellu.messenger_clone.presentation.shared

import dev.bellu.messenger_clone.data.entity.ConversationEntity
import dev.bellu.messenger_clone.data.entity.MessageEntity
import dev.bellu.messenger_clone.data.entity.UserEntity

data class BaseUiState(
    val users: List<UserEntity> = listOf(),
    val messages: List<MessageEntity> = listOf(),
    val conversations: List<ConversationEntity> = listOf()
)