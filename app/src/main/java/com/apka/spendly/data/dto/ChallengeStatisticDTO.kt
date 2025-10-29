package com.apka.spendly.data.dto

import kotlinx.serialization.Serializable

@Serializable
data class ChallengeStatisticDTO(
    val period: String,
    val totalSaved: Double,
    val profitChangePercent: Int,
    val avgChallengeProfit: Double,
    val finishedChallenges: Int,
    val challenges: List<UserChallengeDTO>,
)