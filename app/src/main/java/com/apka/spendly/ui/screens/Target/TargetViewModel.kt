package com.apka.spendly.ui.screens.Target

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.apka.spendly.data.repo.TargetRepo
import com.apka.spendly.ui.screens.AddNewTarget.AddNewTargetUiState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient

class TargetViewModel(private val repo: TargetRepo): ViewModel() {
    private val _uiState = MutableStateFlow(TargetUiState())
    val uiState: StateFlow<TargetUiState> get() = _uiState

    fun setToast(value: String) {
        _uiState.value = _uiState.value.copy(toast = value)
    }

    fun fetchUserTargets() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val result = repo.getTargets()
                withContext(Dispatchers.Main) {
                    _uiState.value = _uiState.value.copy(targets = result)
                }
            } catch (e: Exception) {
                withContext(Dispatchers.Main) {
                    setToast("Error fetching user targets: ${e.message}")
                }
            }
        }
    }
}