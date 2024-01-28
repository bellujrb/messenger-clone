package dev.bellu.messenger_clone.presentation.shared

import dev.bellu.messenger_clone.data.entity.UserEntity

data class BaseUiState(
    val users: List<UserEntity> = listOf(),
)