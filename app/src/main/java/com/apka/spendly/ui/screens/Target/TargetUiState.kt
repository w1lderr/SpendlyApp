package com.apka.spendly.ui.screens.Target

import com.apka.spendly.data.dto.TargetDTO

data class TargetUiState(
    val toast: String = "",
    val targets: List<TargetDTO> = emptyList()
)