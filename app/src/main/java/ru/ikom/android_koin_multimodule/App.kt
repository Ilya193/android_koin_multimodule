package ru.ikom.android_koin_multimodule

import android.app.Application
import org.koin.core.context.startKoin
import ru.ikom.messages.featureMessages

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            modules(appModule, featureMessages)
        }
    }
}