package com.apka.spendly.ui.screens.Statistics

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.apka.spendly.data.dto.UserChallengeDTO
import com.apka.spendly.data.model.WeeklyChartData
import com.apka.spendly.data.repo.ChallengeRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale
import kotlin.math.max

class StatisticsViewModel(private val repo: ChallengeRepo) : ViewModel() {
    private val _uiState = MutableStateFlow(StatisticsUiState())
    val uiState: StateFlow<StatisticsUiState> get() = _uiState

    fun setToast(value: String) {
        _uiState.value = _uiState.value.copy(toast = value)
    }

    fun fetchUserChallengesAndCountTotalSaved() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val userChallenges = repo.getUserChallenges()
                val totalSaved = userChallenges.sumOf { it.totalSaved }

                // Calculate daily savings for the current week
                val dailyData = calculateDailySavingsThisWeek(userChallenges)

                withContext(Dispatchers.Main) {
                    _uiState.value = _uiState.value.copy(
                        userChallenges = userChallenges,
                        totalSaved = totalSaved,
                        weeklyChartData = dailyData.values,
                        weeklyChartLabels = dailyData.labels
                    )
                }
            } catch (e: Exception) {
                withContext(Dispatchers.Main) {
                    setToast("Error fetching user challenges: ${e.message}")
                }
            }
        }
    }

    private fun calculateDailySavingsThisWeek(userChallenges: List<UserChallengeDTO>): WeeklyChartData {
        val calendar = Calendar.getInstance()
        val today = Calendar.getInstance()
        val currentDayOfWeek = today.get(Calendar.DAY_OF_WEEK)

        // Get start of current week (Monday)
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY)

        val dailyData = mutableListOf<Pair<String, Double>>()
        val dayFormat = SimpleDateFormat("EEE", Locale.getDefault()) // Mon, Tue, Wed, etc.

        // Determine how many days to show data for (only up to today)
        val daysToShowData = when (currentDayOfWeek) {
            Calendar.MONDAY -> 1
            Calendar.TUESDAY -> 2
            Calendar.WEDNESDAY -> 3
            Calendar.THURSDAY -> 4
            Calendar.FRIDAY -> 5
            Calendar.SATURDAY -> 6
            Calendar.SUNDAY -> 7
            else -> 1
        }

        // Always show all 7 days of the week for labels, but only show data up to today
        for (i in 0 until 7) {
            val dayStart = calendar.timeInMillis
            val dayLabel = dayFormat.format(calendar.time)

            var dailySavings = 0.0

            // Only calculate savings for days up to today
            if (i < daysToShowData) {
                // Calculate savings for this specific day
                userChallenges.forEach { challenge ->
                    val challengeStartDate = challenge.startDate
                    val dailyChallengeAmount = if (challenge.daysCompleted > 0) {
                        challenge.totalSaved / challenge.daysCompleted
                    } else 0.0

                    // Check if this day falls within the challenge period
                    val challengeEndDate =
                        challengeStartDate + (challenge.daysCompleted * 24 * 60 * 60 * 1000L)

                    if (dayStart >= challengeStartDate && dayStart <= challengeEndDate) {
                        // Calculate which day of the challenge this is
                        val daysSinceStart =
                            ((dayStart - challengeStartDate) / (24 * 60 * 60 * 1000L)).toInt()
                        if (daysSinceStart < challenge.daysCompleted) {
                            dailySavings += dailyChallengeAmount
                        }
                    }
                }
            }
            // For future days (after today), dailySavings remains 0.0

            dailyData.add(
                Pair(
                    dayLabel,
                    max(dailySavings / 100, 0.0)
                )
            ) // Convert to currency format
            calendar.add(Calendar.DAY_OF_MONTH, 1)
        }

        return WeeklyChartData(
            values = dailyData.map { it.second },
            labels = dailyData.map { it.first }
        )
    }
}