package com.apka.spendly.ui.screens.BalanceInfo

import com.apka.spendly.data.dto.TransactionDTO

data class BalanceInfoUiState(
    val toast: String = "",
    val transactions: List<TransactionDTO> = emptyList()
)