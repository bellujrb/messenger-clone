package dev.bellu.messenger_clone.presentation.shared

import dev.bellu.messenger_clone.data.entity.AdvertisingEntity
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.bellu.messenger_clone.data.contracts.MessengerDao
import dev.bellu.messenger_clone.data.entity.ConversationEntity
import dev.bellu.messenger_clone.data.entity.MessageEntity
import dev.bellu.messenger_clone.data.entity.UserEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class BaseViewModel(private val db: MessengerDao) : ViewModel() {

    private val _uiState = MutableStateFlow(BaseUiState())
    val uiState: StateFlow<BaseUiState> = _uiState.asStateFlow()

    fun updateConversationIndex(index: Int) {
        AppState.conversationIndex = index
    }

    init {
        viewModelScope.launch {
            _uiState.value = _uiState.value.copy(
                users = fetchUsers(),
                messages = fetchMessages(),
                conversations = fetchConversations(),
                advertising = fetchAdvertising()
            )
            Log.e(
                "DB", _uiState.value.users.toString() + "\n" +
                        _uiState.value.messages.toString() + "\n" +
                        _uiState.value.conversations.toString() + "\n" +
                        _uiState.value.advertising.toString()
            )
        }
    }

    private suspend fun fetchUsers(): List<UserEntity> {
        val data = withContext(Dispatchers.IO) { db.getAll() }

        return data
    }

    private suspend fun fetchMessages(): List<MessageEntity> {
        val data = withContext(Dispatchers.IO) { db.getAllMessages() }

        return data
    }

    private suspend fun fetchConversations(): List<ConversationEntity> {
        val data = withContext(Dispatchers.IO) { db.getAllConversations() }

        return data
    }

    private suspend fun fetchAdvertising(): List<AdvertisingEntity> {
        val data = withContext(Dispatchers.IO) { db.getAllAdvertising() }

        return data
    }
}