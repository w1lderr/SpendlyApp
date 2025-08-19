package com.apka.spendly.data.dto

import kotlinx.serialization.Serializable

@Serializable
data class TargetDTO(
    val targetId: String,
    val uuid: String,
    val targetName: String,
    val targetDescription: String?,
    val targetAmount: Long,
    val category: String,
    val date: Long,
    val reminder: Boolean
)