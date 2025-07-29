package com.apka.spendly.di

import com.apka.spendly.androidUuidGenerator.AndroidUuidGenerator
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val provideUtilModule = module {
    single { AndroidUuidGenerator(androidContext()) }
}