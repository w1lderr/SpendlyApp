package com.apka.spendly.data.dto

import kotlinx.serialization.Serializable

@Serializable
data class TransactionDTO(
    val transactionId: String,
    val uuid: String,
    val description: String,
    val amount: Long,
    val currencyCode: Int,
    val category: String,
    val date: Long,
)