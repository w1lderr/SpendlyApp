package com.apka.spendly.data.dto

import kotlinx.serialization.Serializable

@Serializable
data class TargetTopUpHistoryDTO(
    val targetTopUpHistoryId: String,
    val targetId: String,
    val amount: Long,
    val timestamp: Long
)