package com.apka.spendly.ui.screens.Target

data class TargetUiItem(
    val targetId: String,
    val uuid: String,
    val targetName: String,
    val targetDescription: String?,
    val targetAmount: Long,
    val category: String,
    val date: Long,
    val completed: Boolean,
    val totalTopUpAmount: Long,
    val progressPercent: Int
)