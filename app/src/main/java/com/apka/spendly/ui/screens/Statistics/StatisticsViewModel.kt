package com.apka.spendly.ui.screens.Statistics

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.apka.spendly.data.dto.ChallengeStatisticDTO
import com.apka.spendly.data.repo.StatisticRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class StatisticsViewModel(private val repo: StatisticRepo) : ViewModel() {
    private val _uiState = MutableStateFlow(StatisticsUiState())
    private val _period = MutableStateFlow("week")
    private val _challengeStat = MutableStateFlow(ChallengeStatisticDTO())
    val uiState: StateFlow<StatisticsUiState> get() = _uiState
    val challengeStat: StateFlow<ChallengeStatisticDTO> get() = _challengeStat
    val period: StateFlow<String> get() = _period

    init {
        getChallengeStats()
    }

    fun setToast(value: String) {
        _uiState.value = _uiState.value.copy(toast = value)
    }

    fun setPeriod(period: String) {
        _period.value = period
        getChallengeStats()
    }

    fun getChallengeStats() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val result = repo.getChallengesStat(period.value)
                _challengeStat.value = result
                Log.i("RESULTTTTTT", result.toString())
            } catch (e: Exception) {
                withContext(Dispatchers.Main) {
                    setToast("Error while getting challenge stats: $e")
                }
            }
        }
    }
}