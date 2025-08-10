package com.apka.spendly.ui.screens.FinanceTips

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.apka.spendly.data.repo.FinanceTipsRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class FinanceTipsViewModel(private val financeTipsRepo: FinanceTipsRepo) : ViewModel() {
    private val _uiState = MutableStateFlow(FinanceTipsUiState())
    val uiState: StateFlow<FinanceTipsUiState> get() = _uiState

    fun setToast(toast: String) {
        _uiState.value = _uiState.value.copy(toast = toast)
    }

    fun fetchAllFinanceTips() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val result = financeTipsRepo.getFinanceTips()
                _uiState.value = _uiState.value.copy(financeTips = result)
            } catch (e: Exception) {
                withContext(Dispatchers.Main) {
                    setToast("Error fetching finance tips: ${e.message}")
                }
            }
        }
    }
}