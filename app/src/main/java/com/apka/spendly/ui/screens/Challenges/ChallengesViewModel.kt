package com.apka.spendly.ui.screens.Challenges

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.apka.spendly.data.repo.ChallengeRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ChallengesViewModel(private val repo: ChallengeRepo) : ViewModel() {
    private val _uiState = MutableStateFlow(ChallengesUiState())
    val uiState: StateFlow<ChallengesUiState> get() = _uiState

    fun setToast(value: String) {
        _uiState.value = _uiState.value.copy(toast = value)
    }

    fun fetchAllChallenges() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                // We receive user challenges and all challenges
                val userChallenges = repo.getUserChallenges()
                val allChallenges = repo.getChallenges()

                // For quick reference — map of user challenge IDs
                val userChallengeIds = userChallenges.map { it.challengeId }.toSet()

                val combinedList = mutableListOf<ChallengeItemUI>()

                // 1. Adding user challenges
                combinedList.addAll(
                    userChallenges.map { user_challenge ->
                        ChallengeItemUI(
                            challengeId = user_challenge.challengeId,
                            name = user_challenge.challengeName,
                            description = user_challenge.challengeDescription,
                            daysCompleted = user_challenge.daysCompleted,
                            daysRequired = user_challenge.daysRequired,
                            totalSaved = user_challenge.totalSaved,
                            status = user_challenge.status
                        )
                    }
                )

                // 2. Add those that are not available to the user
                combinedList.addAll(
                    allChallenges.filter { it.challengeId !in userChallengeIds }
                        .map { challenge ->
                            ChallengeItemUI(
                                challengeId = challenge.challengeId,
                                name = challenge.name,
                                description = challenge.description,
                                daysCompleted = 0,
                                daysRequired = challenge.daysRequired,
                                totalSaved = 0.0,
                                status = "not started"
                            )
                        }
                )

                withContext(Dispatchers.Main) {
                    _uiState.value = _uiState.value.copy(challenges = combinedList)
                }
            } catch (e: Exception) {
                withContext(Dispatchers.Main) {
                    setToast("Error fetching challenges: ${e.message}")
                }
            }
        }
    }

    fun joinChallenge(challengeId: String) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val response = repo.joinChallenge(challengeId)
                withContext(Dispatchers.Main) {
                    setToast(response)
                }
                fetchAllChallenges()
            } catch (e: Exception) {
                withContext(Dispatchers.Main) {
                    setToast("Error joining challenge: ${e.message}")
                }
            }
        }
    }
}