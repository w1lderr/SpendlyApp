package com.apka.spendly.data.dto

import kotlinx.serialization.Serializable

@Serializable
data class CategorySummaryDTO(
    val category: String,
    val total: Long,
    val percentage: Int
)