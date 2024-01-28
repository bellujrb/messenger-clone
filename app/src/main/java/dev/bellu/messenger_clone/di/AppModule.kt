package dev.bellu.messenger_clone.di

import dev.bellu.messenger_clone.data.contracts.MessengerDao
import dev.bellu.messenger_clone.data.database.MessengerDatabase
import dev.bellu.messenger_clone.presentation.screens.chat.ChatViewModel
import dev.bellu.messenger_clone.presentation.shared.BaseViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    single<MessengerDatabase> {
        MessengerDatabase.getDatabase(androidContext())
    }

    single<MessengerDao> {
        get<MessengerDatabase>().messengerDao()
    }

    viewModel<BaseViewModel> {
        BaseViewModel(
            db = get()
        )
    }

    viewModel<ChatViewModel> {
        ChatViewModel(
            db = get()
        )
    }
}