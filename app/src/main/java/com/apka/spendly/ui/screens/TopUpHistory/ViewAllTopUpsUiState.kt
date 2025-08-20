package com.apka.spendly.ui.screens.TopUpHistory

import com.apka.spendly.data.dto.TargetTopUpHistoryDTO

data class ViewAllTopUpsUiState(
    val toast: String = "",
    val topUpHistory: List<TargetTopUpHistoryDTO> = emptyList()
)