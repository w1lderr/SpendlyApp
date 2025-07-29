package com.apka.spendly.data.dto

import kotlinx.serialization.Serializable

@Serializable
data class TokenDTO(
    val uuid: String,
    val token: String
)