package com.apka.spendly.ui.screens.Statistics

import com.apka.spendly.data.dto.UserChallengeDTO

data class StatisticsUiState(
    val toast: String = "",
    val totalSaved: Double = 0.0,
    val userChallenges: List<UserChallengeDTO> = emptyList()
)