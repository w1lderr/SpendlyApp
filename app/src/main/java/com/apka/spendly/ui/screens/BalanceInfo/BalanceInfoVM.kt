package com.apka.spendly.ui.screens.BalanceInfo

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.apka.spendly.data.repo.TransactionRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class BalanceInfoVM(private val repo: TransactionRepo) : ViewModel() {
    private val _uiState = MutableStateFlow(BalanceInfoUiState())
    val uiState: StateFlow<BalanceInfoUiState> get() = _uiState

    fun setToast(toast: String) {
        _uiState.value = _uiState.value.copy(toast = toast)
    }

    fun getTransactions() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val transactions = repo.fetchTransactions()
                _uiState.value = _uiState.value.copy(transactions = transactions)
            } catch (e: Exception) {
                withContext(Dispatchers.Main) {
                    setToast("Error fetching transactions: ${e.message}")
                }
            }
        }
    }
}