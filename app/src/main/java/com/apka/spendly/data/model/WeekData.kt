package com.apka.spendly.data.model

data class WeekData(
    val weekNumber: Int,
    val startDate: Long,
    val endDate: Long,
    var totalSaved: Double
)