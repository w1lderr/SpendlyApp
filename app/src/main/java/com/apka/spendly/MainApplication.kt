package com.apka.spendly

import android.app.Application
import com.apka.spendly.di.appModule
import io.kotzilla.sdk.analytics.koin.analytics
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MainApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(applicationContext)
            analytics()
            modules(appModule())
        }
    }
}