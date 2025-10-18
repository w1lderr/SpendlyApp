package com.apka.spendly.ui.screens.ViewTarget

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.apka.spendly.data.dto.TargetTopUpHistoryDTO
import com.apka.spendly.data.repo.TargetRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ViewTargetViewModel(private val repo: TargetRepo) : ViewModel() {
    private val _uiState = MutableStateFlow(ViewTargetUiState())
    private val _contribution = MutableStateFlow("")
    val uiState: StateFlow<ViewTargetUiState> get() = _uiState
    val contribution: StateFlow<String> get() = _contribution

    fun setToast(value: String) {
        _uiState.value = _uiState.value.copy(toast = value)
    }

    fun setShowAlertDialogState(value: Boolean) {
        _uiState.value = _uiState.value.copy(showAlertDialog = value)
    }

    fun onContributionChanged(value: String) {
        _contribution.value = value
    }

    fun addContribution(targetId: String) {
        val contributionValue = _contribution.value
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val amountConverter = contributionValue.toLong() * 100

                val result = repo.addContribution(
                    TargetTopUpHistoryDTO(
                        targetTopUpHistoryId = "",
                        targetId = targetId,
                        amount = amountConverter,
                        timestamp = 0L
                    )
                )

                if (result == 200) {
                    withContext(Dispatchers.Main) {
                        setToast("Contribution added successfully")
                        setShowAlertDialogState(false)
                    }
                } else {
                    withContext(Dispatchers.Main) {
                        setToast("Failed to add contribution: HTTP $result")
                    }
                }
            } catch (e: Exception) {
                withContext(Dispatchers.Main) {
                    setToast("Error while adding contribution: ${e.message}")
                }
            }
        }
    }
}