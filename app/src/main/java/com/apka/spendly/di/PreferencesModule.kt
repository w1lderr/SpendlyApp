package com.apka.spendly.di

import com.apka.spendly.data.preferences.AuthenticationPreferencesDataSource
import org.koin.dsl.module

val providePreferencesModule = module {
    single { AuthenticationPreferencesDataSource(get()) }
}