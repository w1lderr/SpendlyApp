package com.apka.spendly.ui.screens.ChatScreen

import com.apka.spendly.data.dto.MessageDTO

data class ChatUiState(
    val toast: String = "",
    var messages: List<MessageDTO> = emptyList()
)