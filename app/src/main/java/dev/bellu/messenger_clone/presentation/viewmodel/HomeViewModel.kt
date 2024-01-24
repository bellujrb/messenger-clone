package dev.bellu.messenger_clone.presentation.viewmodel

import android.util.Log
import androidx.compose.runtime.rememberCoroutineScope
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.bellu.messenger_clone.data.database.MessengerDatabase
import dev.bellu.messenger_clone.data.entity.UserEntity
import dev.bellu.messenger_clone.presentation.screens.HomeUiState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class HomeViewModel(private val db: MessengerDatabase): ViewModel(){

    private val _uiState = MutableStateFlow(HomeUiState())
    val uiState: StateFlow<HomeUiState> = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            fetchDatabase()
        }
    }
    private suspend fun fetchDatabase(){
        val data = withContext(Dispatchers.IO){
            db.messengerDao().getAll()
        }

        _uiState.value = _uiState.value.copy(
            users = data
        )
        Log.e("DB_Result", data.toString())
    }
}