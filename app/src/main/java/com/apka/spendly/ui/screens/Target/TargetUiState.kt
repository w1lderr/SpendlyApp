package com.apka.spendly.ui.screens.Target

data class TargetUiState(
    val toast: String = "",
    val targets: List<TargetUiItem> = emptyList()
)