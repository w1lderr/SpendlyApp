package com.apka.spendly.data.dto

import kotlinx.serialization.Serializable

@Serializable
data class ChallengeDTO(
    val challengeId: String,
    val name: String,
    val description: String,
    val forbiddenCategory: String,
    val daysRequired: Int
)