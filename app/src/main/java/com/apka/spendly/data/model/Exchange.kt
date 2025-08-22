package com.apka.spendly.data.model

import kotlinx.serialization.Serializable

@Serializable
data class Exchange(
    val r030: Int = 0,
    val txt: String = "",
    val rate: Double = 0.0,
    val cc: String = "",
    val exchangedate: String = "",
)