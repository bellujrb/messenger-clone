package dev.bellu.messenger_clone.presentation.screens.advertising

import dev.bellu.messenger_clone.data.entity.AdvertisingEntity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.bellu.messenger_clone.data.contracts.MessengerDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class AdvertisingViewModel(private val db: MessengerDao): ViewModel() {

    // Example
    suspend fun addAdvertising(){
        withContext(Dispatchers.IO){
            db.createAdvertising(
                advertising = AdvertisingEntity(
                    name = "Messenger Clone",
                    subtitle = "I am creating a clone of an existing application to study Android development features",
                    photo = ""
                )
            )
        }
    }
}