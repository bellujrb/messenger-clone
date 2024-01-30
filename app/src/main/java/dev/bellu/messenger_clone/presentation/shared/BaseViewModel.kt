package dev.bellu.messenger_clone.presentation.shared

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.bellu.messenger_clone.data.contracts.MessengerDao
import dev.bellu.messenger_clone.data.entity.UserEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class BaseViewModel(private val db: MessengerDao): ViewModel(){

    private val _uiState = MutableStateFlow(BaseUiState())
    val uiState: StateFlow<BaseUiState> = _uiState.asStateFlow()

    fun updateConversationIndex(index: Int){
        AppState.conversationIndex = index
    }

    init {
        viewModelScope.launch {
            _uiState.value = _uiState.value.copy(
                users = fetchDatabase()
            )
            Log.e("DB", _uiState.value.users.toString())
        }
    }

    private suspend fun fetchDatabase(): List<UserEntity> {

        val data = withContext(Dispatchers.IO) {
            db.getAll()
        }

        return data
    }
}