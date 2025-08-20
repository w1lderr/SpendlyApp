package com.apka.spendly.ui.screens.Target

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.apka.spendly.data.repo.TargetRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class TargetViewModel(private val repo: TargetRepo) : ViewModel() {
    private val _uiState = MutableStateFlow(TargetUiState())
    val uiState: StateFlow<TargetUiState> get() = _uiState

    fun setToast(value: String) {
        _uiState.value = _uiState.value.copy(toast = value)
    }

    fun fetchTargets() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val targets = repo.getTargets()

                val uiItems = targets.map { target ->
                    val totalTopUpAmount = repo.getTotalTopUpAmount(target.targetId)
                    val progressPercent = if (target.targetAmount > 0) {
                        val percentage = (totalTopUpAmount.toDouble() / target.targetAmount.toDouble()) * 100
                        percentage.coerceIn(0.0, 100.0).toInt()
                    } else {
                        0
                    }

                    TargetUiItem(
                        targetId = target.targetId,
                        uuid = target.uuid,
                        targetName = target.targetName,
                        targetDescription = target.targetDescription,
                        targetAmount = target.targetAmount,
                        category = target.category,
                        date = target.date,
                        completed = target.completed,
                        totalTopUpAmount = totalTopUpAmount,
                        progressPercent = progressPercent
                    )
                }

                withContext(Dispatchers.Main) {
                    _uiState.value = _uiState.value.copy(
                        targets = uiItems
                    )
                }
            } catch (e: Exception) {
                withContext(Dispatchers.Main) {
                    _uiState.value = _uiState.value.copy(toast = "Error fetching targets: ${e.message}")
                }
            }
        }
    }
}