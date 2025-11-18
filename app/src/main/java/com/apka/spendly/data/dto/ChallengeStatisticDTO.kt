package com.apka.spendly.data.dto

import kotlinx.serialization.Serializable

@Serializable
data class ChallengeStatisticDTO(
    val period: String = "",
    val totalSaved: Double = 0.0,
    val profitChangePercent: Int = 0,
    val avgChallengeProfit: Double = 0.0,
    val finishedChallenges: Int = 0,
    val challenges: List<UserChallengeDTO> = emptyList(),
)