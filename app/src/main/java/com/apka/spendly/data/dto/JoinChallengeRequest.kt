package com.apka.spendly.data.dto

import kotlinx.serialization.Serializable

@Serializable
data class JoinChallengeRequest(
    val uuid: String,
    val challengeId: String
)