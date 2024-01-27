package dev.bellu.messenger_clone.presentation.screens.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavHostController
import dev.bellu.messenger_clone.data.database.MessengerDatabase
import dev.bellu.messenger_clone.data.entity.UserEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class HomeViewModel(private val db: MessengerDatabase) : ViewModel() {

    private val _uiState = MutableStateFlow(HomeUiState())
    val uiState: StateFlow<HomeUiState> = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            _uiState.value = _uiState.value.copy(
                users = fetchDatabase()
            )
        }
    }

    private suspend fun fetchDatabase(): List<UserEntity> {

        val data = withContext(Dispatchers.IO) {
            db.messengerDao().getAll()
        }

        return data
    }
}