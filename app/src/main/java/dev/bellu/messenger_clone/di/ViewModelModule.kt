package dev.bellu.messenger_clone.di

import dev.bellu.messenger_clone.presentation.screens.advertising.AdvertisingViewModel
import dev.bellu.messenger_clone.presentation.screens.chat.ChatViewModel
import dev.bellu.messenger_clone.presentation.screens.friends.FriendsViewModel
import dev.bellu.messenger_clone.presentation.shared.BaseViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {

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

    viewModel<FriendsViewModel>{
        FriendsViewModel(
            db = get()
        )
    }

    viewModel<AdvertisingViewModel>{
        AdvertisingViewModel(
            db = get()
        )
    }
}