package com.apka.spendly.data.model

import kotlinx.serialization.Serializable

@Serializable
data class Token(
    val uuid: String,
    val token: String
)