package com.apka.spendly.ui.screens.HomeScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.apka.spendly.androidUuidGenerator.AndroidUuidGenerator
import com.apka.spendly.data.dto.MonthlySummaryDTO
import com.apka.spendly.data.repo.HomeRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.Calendar

class HomeViewModel(
    private val repo: HomeRepo,
    private val uuidGenerator: AndroidUuidGenerator
) : ViewModel() {
    private val _totalSumSpending = MutableStateFlow(0L)
    private val _categories = MutableStateFlow(MonthlySummaryDTO(0L, emptyList()))
    private val _uiState = MutableStateFlow(HomeUiState())
    private val _balance = MutableStateFlow(0L)
    private val _greeting = MutableStateFlow(getGreetingBasedOnTime())
    val greeting: StateFlow<String> = _greeting
    val balance: StateFlow<Long> = _balance
    val uiState: StateFlow<HomeUiState> = _uiState
    val categories: StateFlow<MonthlySummaryDTO> = _categories
    val totalSumSpending: StateFlow<Long> get() = _totalSumSpending

    init {
        getBalance()
        getMonthlyCategories()
    }

    private fun calculateTotalSumSpending() {
        val total = _categories.value.categories.sumOf { it.total }
        _totalSumSpending.value = total
    }

    private fun getGreetingBasedOnTime(): String {
        val hour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY)
        return when {
            hour in 5..11 -> "Good morning"
            hour in 12..16 -> "Good afternoon"
            hour in 17..20 -> "Good evening"
            else -> "Good night"
        }
    }

    fun setToast(toast: String) {
        _uiState.value = _uiState.value.copy(toast = toast)
    }

    private fun setBalance(balance: Long) {
        _balance.value = balance
    }

    fun getBalance() {
        val uuid = uuidGenerator.getOrCreateGuid()
        viewModelScope.launch(Dispatchers.IO) {
            try {
                setBalance(repo.getBalance(uuid) / 100)
            } catch (e: Exception) {
                withContext(Dispatchers.Main) {
                    setToast("Error fetching balance: ${e.message}")
                }
            }
        }
    }

    fun getMonthlyCategories() {
        val uuid = uuidGenerator.getOrCreateGuid()
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val monthlyCategories = repo.getMonthlyCategories(uuid)
                _categories.value = monthlyCategories
                calculateTotalSumSpending()
            } catch (e: Exception) {
                withContext(Dispatchers.Main) {
                    setToast("Error fetching monthly categories: ${e.message}")
                }
            }
        }
    }
}