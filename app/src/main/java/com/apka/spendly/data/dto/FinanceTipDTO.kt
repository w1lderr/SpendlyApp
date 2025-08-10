package com.apka.spendly.data.dto

import kotlinx.serialization.Serializable

@Serializable
data class FinanceTipDTO(
    val finTipId: String,
    val finTipIcon: String,
    val finTipTitle: String,
    val finTipDesc: String
)