package com.apka.spendly.ui.screens.SetToken

data class SetTokenUiState(
    val toast: String = "",
    val navigateToHome: Boolean = false,
    val isTermsOfUseAgreed: Boolean = false
)