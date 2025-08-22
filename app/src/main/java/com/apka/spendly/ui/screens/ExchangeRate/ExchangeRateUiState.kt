package com.apka.spendly.ui.screens.ExchangeRate

import com.apka.spendly.data.model.Exchange

data class ExchangeRateUiState(
    val toast: String = "",
    val exchangeRates: List<Exchange> = emptyList()
)