package com.apka.spendly.di

import com.apka.spendly.ui.screens.DuringLoading.DuringLoadingViewModel
import com.apka.spendly.ui.screens.HomeScreen.HomeViewModel
import com.apka.spendly.ui.screens.LlamaScreen.LlamaViewModel
import com.apka.spendly.ui.screens.SetToken.SetTokenViewModel
import org.koin.dsl.module

val provideViewModelModule = module {
    single<SetTokenViewModel> {
        SetTokenViewModel(
            get(),
            get(),
            get()
        )
    }
    single<HomeViewModel> { HomeViewModel(get(), get()) }
    single<DuringLoadingViewModel> { DuringLoadingViewModel(get()) }
    single<LlamaViewModel> { LlamaViewModel(get(), get(), get()) }
}