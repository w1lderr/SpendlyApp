package com.apka.spendly.ui.screens.ExchangeRate

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.apka.spendly.data.repo.ExchangeRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.time.format.DateTimeFormatter

class ExchangeRateVM(private val repo: ExchangeRepo): ViewModel() {
    private val _uiState = MutableStateFlow(ExchangeRateUiState())
    val uiState: StateFlow<ExchangeRateUiState> get() = _uiState

    fun setToast(value: String) {
        _uiState.value = _uiState.value.copy(toast = value)
    }

    fun fetchExchangeRates() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val result = repo.getExchangeRatesByNBU()
                Log.i("EXCHANGE RATE LIST", "$result")
                withContext(Dispatchers.Main) {
                    _uiState.value = _uiState.value.copy(exchangeRates = result)
                }
            } catch (e: Exception) {
                withContext(Dispatchers.Main) {
                    setToast("Error fetching exchange rates: ${e.message}")
                }
            }
        }
    }
}