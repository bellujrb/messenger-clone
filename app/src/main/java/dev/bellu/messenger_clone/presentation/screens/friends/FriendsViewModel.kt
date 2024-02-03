package dev.bellu.messenger_clone.presentation.screens.friends

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.bellu.messenger_clone.data.contracts.MessengerDao
import dev.bellu.messenger_clone.data.entity.ConversationEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class FriendsViewModel(private val db: MessengerDao) : ViewModel() {

    private var conversations: List<ConversationEntity> = listOf()
    init {
        viewModelScope.launch {
            conversations = loadConversations()
            Log.e("Friends", conversations.toString())
        }
    }

    private suspend fun loadConversations(): List<ConversationEntity>{

        var conversationsList: List<ConversationEntity>

        withContext(Dispatchers.IO){
            conversationsList = db.getAllConversations()
        }

        return conversationsList
    }
    suspend fun createConversation(index: Int, user1: Int, user2: Int, navigateToChat: () -> Unit) {

        val conversationIdExists = conversations.any { it.id == index}

        if(!conversationIdExists){
            withContext(Dispatchers.IO) {
                db.createConversation(
                    ConversationEntity(
                        id = index,
                        user1Id = user1,
                        user2Id = user2 + 1
                    )
                )
            }
            navigateToChat()
        } else {
            navigateToChat()
            Log.e("ERROR CREATE CONVERSATION", "ID EXIST: $index")
        }
    }
}