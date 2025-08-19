package com.apka.spendly.ui.screens.Target

import com.apka.spendly.data.dto.TargetDTO
import com.apka.spendly.data.dto.UserChallengeDTO

data class TargetUiState(
    val toast: String = "",
    val targets: List<TargetDTO> = emptyList()
)