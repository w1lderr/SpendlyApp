package com.apka.spendly.di

import com.apka.spendly.api.DigestAuthHttpClient
import org.koin.dsl.module

val provideNetworkModule = module {
    single {
        DigestAuthHttpClient(
            username = "1m_the_b3st_bcs_1m_w1lderrrr",
            password = "2DcnacUqK1qTO417PrE46KP169XBQj"
        ).client
    }
}