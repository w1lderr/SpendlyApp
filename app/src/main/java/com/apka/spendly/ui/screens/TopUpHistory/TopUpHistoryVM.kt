package com.apka.spendly.ui.screens.TopUpHistory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.apka.spendly.data.repo.TargetRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class TopUpHistoryVM(
    private val repo: TargetRepo
) : ViewModel() {
    private val _uiState = MutableStateFlow(ViewAllTopUpsUiState())
    val uiState: StateFlow<ViewAllTopUpsUiState> get() = _uiState

    fun setToast(toast: String) {
        _uiState.value = _uiState.value.copy(toast = toast)
    }

    fun fetchTopUpHistory(targetId: String) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val result = repo.getTargetTopUpHistory(targetId)
                    .sortedByDescending { it.timestamp }
                _uiState.value = _uiState.value.copy(topUpHistory = result)
            } catch (e: Exception) {
                withContext(Dispatchers.Main) {
                    setToast("Failed to fetch top-up history: ${e.message}")
                }
            }
        }
    }
}