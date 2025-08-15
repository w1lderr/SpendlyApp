package com.apka.spendly.data.dto

import kotlinx.serialization.Serializable

@Serializable
data class UserChallengeDTO(
    val userChallengeId: String,
    val uuid: String,
    val challengeId: String,
    val challengeName: String,
    val challengeDescription: String,
    val daysRequired: Int,
    val daysCompleted: Int,
    val totalSaved: Double,
    val status: String,
    val startDate: Long
)