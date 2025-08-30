package com.apka.spendly.ui.screens.AIScreen

import com.apka.spendly.data.dto.MessageDTO

data class AIUiState(
    val toast: String = "",
    var messages: List<MessageDTO> = emptyList()
)