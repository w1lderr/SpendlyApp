package com.apka.spendly.ui.screens.Statistics

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.apka.spendly.data.repo.ChallengeRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class StatisticsViewModel(private val repo: ChallengeRepo) : ViewModel() {
    private val _uiState = MutableStateFlow(StatisticsUiState())
    val uiState: StateFlow<StatisticsUiState> get() = _uiState

    fun setToast(value: String) {
        _uiState.value = _uiState.value.copy(toast = value)
    }

    fun fetchUserChallengesAndCountTotalSaved() {
        var totalSaved = 0.0
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val userChallenges = repo.getUserChallenges()

                userChallenges.forEach { challenge ->
                    totalSaved += challenge.totalSaved
                }

                withContext(Dispatchers.Main) {
                    _uiState.value = _uiState.value.copy(userChallenges = userChallenges)
                    _uiState.value = _uiState.value.copy(totalSaved = totalSaved)
                }
            } catch (e: Exception) {
                withContext(Dispatchers.Main) {
                    setToast("Error fetching user challenges: ${e.message}")
                }
            }
        }
    }
}