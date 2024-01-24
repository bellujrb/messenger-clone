package dev.bellu.messenger_clone.presentation.screens

import dev.bellu.messenger_clone.data.entity.UserEntity

data class HomeUiState(
    val users: List<UserEntity> = listOf()
)
