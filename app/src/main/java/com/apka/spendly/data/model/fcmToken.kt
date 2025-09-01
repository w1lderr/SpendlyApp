package com.apka.spendly.data.model

import kotlinx.serialization.Serializable

@Serializable
data class fcmToken(
    val uuid: String,
    val fcmToken: String
)