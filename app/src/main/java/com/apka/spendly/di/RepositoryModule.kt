package com.apka.spendly.di

import com.apka.spendly.data.repo.AuthenticationRepo
import com.apka.spendly.data.repo.HomeRepo
import com.apka.spendly.data.repo.TokenRepo
import com.apka.spendly.data.repo.TransactionRepo
import org.koin.dsl.module

val provideRepositoryModule = module {
    single<TransactionRepo> { TransactionRepo(get()) }
    single<TokenRepo> { TokenRepo(get()) }
    single<AuthenticationRepo> { AuthenticationRepo(get()) }
    single<HomeRepo> { HomeRepo(get()) }
}