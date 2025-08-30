package com.apka.spendly.di

import com.apka.spendly.ui.screens.AddNewTarget.AddNewTargetViewModel
import com.apka.spendly.ui.screens.BalanceInfo.BalanceInfoVM
import com.apka.spendly.ui.screens.Challenges.ChallengesViewModel
import com.apka.spendly.ui.screens.DuringLoading.DuringLoadingViewModel
import com.apka.spendly.ui.screens.ExchangeRate.ExchangeRateVM
import com.apka.spendly.ui.screens.FinanceTips.FinanceTipsViewModel
import com.apka.spendly.ui.screens.HomeScreen.HomeViewModel
import com.apka.spendly.ui.screens.SetToken.SetTokenViewModel
import com.apka.spendly.ui.screens.Settings.SettingsViewModel
import com.apka.spendly.ui.screens.Statistics.StatisticsViewModel
import com.apka.spendly.ui.screens.Target.TargetViewModel
import com.apka.spendly.ui.screens.TopUpHistory.TopUpHistoryVM
import com.apka.spendly.ui.screens.ViewTarget.ViewTargetViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val provideViewModelModule = module {
    viewModel<SetTokenViewModel> {
        SetTokenViewModel(
            get(),
            get(),
            get(),
            get()
        )
    }
    viewModel<HomeViewModel> { HomeViewModel(get(), get()) }
    viewModel<DuringLoadingViewModel> { DuringLoadingViewModel(get()) }
    viewModel<BalanceInfoVM> { BalanceInfoVM(get()) }
    viewModel<FinanceTipsViewModel> { FinanceTipsViewModel(get()) }
    viewModel<ChallengesViewModel> { ChallengesViewModel(get()) }
    viewModel<StatisticsViewModel> { StatisticsViewModel(get()) }
    viewModel<AddNewTargetViewModel> { AddNewTargetViewModel(get(), get()) }
    viewModel<TargetViewModel> { TargetViewModel(get()) }
    viewModel<ViewTargetViewModel> { ViewTargetViewModel(get()) }
    viewModel<TopUpHistoryVM> { TopUpHistoryVM(get()) }
    viewModel<ExchangeRateVM> { ExchangeRateVM(get()) }
    viewModel<SettingsViewModel> { SettingsViewModel(get()) }
}