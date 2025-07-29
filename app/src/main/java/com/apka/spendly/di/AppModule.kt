package com.apka.spendly.di

fun appModule() = listOf(
    provideNetworkModule,
    provideRepositoryModule,
    provideViewModelModule,
    provideUtilModule,
    providePreferencesModule
)