package dev.bellu.messenger_clone.presentation.screens.chat

import androidx.lifecycle.ViewModel
import androidx.navigation.NavHostController

class ChatViewModel: ViewModel() {

    val img =
        "https://images.unsplash.com/photo-1596215143922-eedeaba0d91c?q=80&w=1887&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"

    val messages: List<String> = listOf(
        "Hello, Jacob!",
        "How are you doing?"
    )

    val messagesTwo: List<String> = listOf(
        "Hello!",
        "I'm very good"
    )
}