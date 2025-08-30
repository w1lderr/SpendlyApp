package com.apka.spendly.data.model

import kotlinx.serialization.Serializable

@Serializable
data class Message(
    val uuid: String,
    val sender: String,
    val content: String,
)