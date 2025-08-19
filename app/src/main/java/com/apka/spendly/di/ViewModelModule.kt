package com.apka.spendly.di

import com.apka.spendly.ui.screens.AddNewTarget.AddNewTargetViewModel
import com.apka.spendly.ui.screens.BalanceInfo.BalanceInfoVM
import com.apka.spendly.ui.screens.Challenges.ChallengesViewModel
import com.apka.spendly.ui.screens.DuringLoading.DuringLoadingViewModel
import com.apka.spendly.ui.screens.FinanceTips.FinanceTipsViewModel
import com.apka.spendly.ui.screens.HomeScreen.HomeViewModel
import com.apka.spendly.ui.screens.LlamaScreen.LlamaViewModel
import com.apka.spendly.ui.screens.SetToken.SetTokenViewModel
import com.apka.spendly.ui.screens.Statistics.StatisticsViewModel
import com.apka.spendly.ui.screens.Target.TargetViewModel
import com.apka.spendly.ui.screens.ViewTarget.ViewTargetViewModel
import org.koin.dsl.module

val provideViewModelModule = module {
    single<SetTokenViewModel> {
        SetTokenViewModel(
            get(),
            get(),
            get(),
            get()
        )
    }
    single<HomeViewModel> { HomeViewModel(get(), get()) }
    single<DuringLoadingViewModel> { DuringLoadingViewModel(get()) }
    single<LlamaViewModel> { LlamaViewModel(get(), get(), get()) }
    single<BalanceInfoVM> { BalanceInfoVM(get()) }
    single<FinanceTipsViewModel> { FinanceTipsViewModel(get()) }
    single<ChallengesViewModel> { ChallengesViewModel(get()) }
    single<StatisticsViewModel> { StatisticsViewModel(get()) }
    single<AddNewTargetViewModel> { AddNewTargetViewModel(get()) }
    single<TargetViewModel> { TargetViewModel(get()) }
    single<ViewTargetViewModel> { ViewTargetViewModel(get()) }
}