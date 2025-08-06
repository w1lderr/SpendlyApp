package com.apka.spendly.ui.screens.LlamaScreen

import com.apka.spendly.data.dto.MessageDTO

data class LlamaUiState(
    val toast: String = "",
    var messages: List<MessageDTO> = emptyList()
)