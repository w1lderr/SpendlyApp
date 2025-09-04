package com.apka.spendly.ui.screens.Statistics

import com.apka.spendly.data.dto.UserChallengeDTO

data class StatisticsUiState(
    val userChallenges: List<UserChallengeDTO> = emptyList(),
    val totalSaved: Double = 0.0,
    val weeklyChartData: List<Double> = emptyList(),
    val weeklyChartLabels: List<String> = emptyList(),
    val toast: String = ""
)