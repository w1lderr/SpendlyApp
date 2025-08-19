package com.apka.spendly.ui.screens.ViewTarget

import androidx.lifecycle.ViewModel
import com.apka.spendly.data.repo.TargetRepo
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class ViewTargetViewModel(private val repo: TargetRepo) : ViewModel() {
    private val _uiState = MutableStateFlow(ViewTargetUiState())
    val uiState: StateFlow<ViewTargetUiState> get() = _uiState

    fun setToast(value: String) {
        _uiState.value = _uiState.value.copy(toast = value)
    }


}