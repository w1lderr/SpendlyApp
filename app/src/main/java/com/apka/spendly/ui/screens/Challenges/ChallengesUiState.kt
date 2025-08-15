package com.apka.spendly.ui.screens.Challenges

data class ChallengesUiState(
    val toast: String = "",
    val challenges: List<ChallengeItemUI> = emptyList()
)