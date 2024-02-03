package dev.bellu.messenger_clone

import android.app.Application
import dev.bellu.messenger_clone.di.appModule
import dev.bellu.messenger_clone.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MessengerApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@MessengerApplication)
            modules(
                appModule,
                viewModelModule
            )
        }
    }
}