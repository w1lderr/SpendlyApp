package com.apka.spendly.data.dto

import kotlinx.serialization.Serializable

@Serializable
data class MonthlySummaryDTO(
    val total: Long = 0,
    val categories: List<CategorySummaryDTO> = emptyList()
)