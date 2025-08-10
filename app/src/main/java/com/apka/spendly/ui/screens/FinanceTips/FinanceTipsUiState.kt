package com.apka.spendly.ui.screens.FinanceTips

import com.apka.spendly.data.dto.FinanceTipDTO

data class FinanceTipsUiState(
    val toast: String = "",
    val financeTips: List<FinanceTipDTO> = emptyList()
)