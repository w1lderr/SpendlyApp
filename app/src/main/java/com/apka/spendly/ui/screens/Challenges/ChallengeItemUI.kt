package com.apka.spendly.ui.screens.Challenges

data class ChallengeItemUI(
    val challengeId: String,
    val name: String,
    val description: String,
    val daysCompleted: Int,
    val daysRequired: Int,
    val totalSaved: Double,
    val status: String // "Not Started", "Started", "Finished"
)