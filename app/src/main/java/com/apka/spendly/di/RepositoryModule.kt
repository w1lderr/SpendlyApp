package com.apka.spendly.di

import com.apka.spendly.data.repo.AuthenticationRepo
import com.apka.spendly.data.repo.ChallengeRepo
import com.apka.spendly.data.repo.FCMTokenRepo
import com.apka.spendly.data.repo.FinanceTipsRepo
import com.apka.spendly.data.repo.HomeRepo
import com.apka.spendly.data.repo.MessageRepo
import com.apka.spendly.data.repo.TargetRepo
import com.apka.spendly.data.repo.TokenRepo
import com.apka.spendly.data.repo.TransactionRepo
import org.koin.dsl.module

val provideRepositoryModule = module {
    single<TransactionRepo> { TransactionRepo(get(), get()) }
    single<TokenRepo> { TokenRepo(get()) }
    single<AuthenticationRepo> { AuthenticationRepo(get()) }
    single<HomeRepo> { HomeRepo(get()) }
    single<MessageRepo> { MessageRepo(get(), get()) }
    single<FCMTokenRepo> { FCMTokenRepo(get()) }
    single<FinanceTipsRepo> { FinanceTipsRepo(get()) }
    single<ChallengeRepo> { ChallengeRepo(get(), get()) }
    single<TargetRepo> { TargetRepo(get(), get()) }
}