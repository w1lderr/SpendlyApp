package com.apka.spendly.data.dto

import kotlinx.serialization.Serializable

@Serializable
data class MessageDTO(
    val messageId: String,
    val uuid: String,
    val sender: String,
    val content: String,
    val timestamp: Long
)