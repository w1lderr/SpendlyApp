package com.apka.spendly.ui.screens.Statistics

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.apka.spendly.data.model.WeekData
import com.apka.spendly.data.model.WeeklyChartData
import com.apka.spendly.data.repo.ChallengeRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.Calendar
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

                // Calculate weekly savings for the current month
                val weeklyData = calculateWeeklySavings(userChallenges)

                withContext(Dispatchers.Main) {
                    _uiState.value = _uiState.value.copy(
                        userChallenges = userChallenges,
                        totalSaved = totalSaved,
                        weeklyChartData = weeklyData.values,
                        weeklyChartLabels = weeklyData.labels
                    )
                }
            } catch (e: Exception) {
                withContext(Dispatchers.Main) {
                    setToast("Error fetching user challenges: ${e.message}")
                }
            }
        }
    }

    private fun calculateWeeklySavings(userChallenges: List<com.apka.spendly.data.dto.UserChallengeDTO>): WeeklyChartData {
        val calendar = Calendar.getInstance()
        val currentMonth = calendar.get(Calendar.MONTH)
        val currentYear = calendar.get(Calendar.YEAR)

        // Get first day of current month
        calendar.set(currentYear, currentMonth, 1)
        val firstDayOfMonth = calendar.timeInMillis

        // Get last day of current month
        calendar.set(currentYear, currentMonth, calendar.getActualMaximum(Calendar.DAY_OF_MONTH))
        val lastDayOfMonth = calendar.timeInMillis

        // Initialize weekly data for current month (4-5 weeks)
        val weeksInMonth = mutableListOf<WeekData>()
        calendar.set(currentYear, currentMonth, 1)

        var weekNumber = 1
        while (calendar.timeInMillis <= lastDayOfMonth) {
            val weekStart = calendar.timeInMillis
            calendar.add(Calendar.DAY_OF_MONTH, 6)
            val weekEnd = minOf(calendar.timeInMillis, lastDayOfMonth)

            weeksInMonth.add(
                WeekData(
                    weekNumber = weekNumber,
                    startDate = weekStart,
                    endDate = weekEnd,
                    totalSaved = 0.0
                )
            )

            calendar.add(Calendar.DAY_OF_MONTH, 1)
            weekNumber++
        }

        // Calculate savings for each week based on challenge progress
        userChallenges.forEach { challenge ->
            val challengeStartDate = challenge.startDate
            val dailySavings = if (challenge.daysCompleted > 0) {
                challenge.totalSaved / challenge.daysCompleted
            } else 0.0

            // Distribute savings across weeks based on challenge progress
            weeksInMonth.forEach { week ->
                val daysInWeek = getDaysInWeekForChallenge(
                    challengeStartDate,
                    challenge.daysCompleted,
                    week.startDate,
                    week.endDate
                )
                week.totalSaved += daysInWeek * dailySavings
            }
        }

        return WeeklyChartData(
            values = weeksInMonth.map {
                max(
                    it.totalSaved / 100,
                    0.0
                )
            }, // Convert to currency format
            labels = weeksInMonth.map { "Week ${it.weekNumber}" }
        )
    }

    private fun getDaysInWeekForChallenge(
        challengeStartDate: Long,
        daysCompleted: Int,
        weekStart: Long,
        weekEnd: Long
    ): Int {
        val challengeEndDate = challengeStartDate + (daysCompleted * 24 * 60 * 60 * 1000L)

        val overlapStart = maxOf(challengeStartDate, weekStart)
        val overlapEnd = minOf(challengeEndDate, weekEnd)

        return if (overlapStart <= overlapEnd) {
            ((overlapEnd - overlapStart) / (24 * 60 * 60 * 1000L)).toInt() + 1
        } else {
            0
        }
    }
}