package com.apka.spendly.data.dto

import kotlinx.serialization.Serializable

@Serializable
data class FCMTokenDTO(
    val fcmTokenId: String,
    val uuid: String,
    val fcmToken: String
)