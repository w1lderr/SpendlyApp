package com.apka.spendly.data.model

data class AddTarget(
    val targetName: String = "",
    val targetDescription: String = "",
    val targetAmount: String = "",
    val category: String = "",
    val enabledReminder: Boolean = false
)