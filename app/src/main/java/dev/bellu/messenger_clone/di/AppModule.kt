package dev.bellu.messenger_clone.di

import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.rememberNavController
import dev.bellu.messenger_clone.data.contracts.MessengerDao
import dev.bellu.messenger_clone.data.database.MessengerDatabase
import dev.bellu.messenger_clone.presentation.screens.chat.ChatViewModel
import dev.bellu.messenger_clone.presentation.screens.home.HomeViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    single {
        MessengerDatabase.getDatabase(androidContext())
    }

    viewModel<HomeViewModel> {
        HomeViewModel(
            db = get()
        )
    }

    viewModel<ChatViewModel>{
        ChatViewModel()
    }
}