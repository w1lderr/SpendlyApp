package com.apka.spendly.ui.screens.AddNewTarget

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.apka.spendly.androidUuidGenerator.AndroidUuidGenerator
import com.apka.spendly.data.dto.TargetDTO
import com.apka.spendly.data.model.AddTarget
import com.apka.spendly.data.repo.TargetRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class AddNewTargetViewModel(
    private val repo: TargetRepo,
    private val androidUuidGenerator: AndroidUuidGenerator
) : ViewModel() {
    private val _uiState = MutableStateFlow(AddNewTargetUiState())
    private val _target = MutableStateFlow(AddTarget())
    val uiState: StateFlow<AddNewTargetUiState> get() = _uiState
    val target: StateFlow<AddTarget> get() = _target

    fun onDispose() {
        setIsNavigateStatus(false)
        _target.value = AddTarget()
    }

    fun setToast(value: String) {
        _uiState.value = _uiState.value.copy(toast = value)
    }

    private fun setIsNavigateStatus(value: Boolean) {
        _uiState.value = _uiState.value.copy(isNavigate = value)
    }

    fun onNameChanged(value: String) {
        _target.value = _target.value.copy(targetName = value)
    }

    fun onDescriptionChanged(value: String) {
        _target.value = _target.value.copy(targetDescription = value)
    }

    fun onAmountChanged(value: String) {
        _target.value = _target.value.copy(targetAmount = value)
    }

    fun onCategoryChanged(value: String) {
        _target.value = _target.value.copy(category = value)
    }

    fun onReminderChanged(value: Boolean) {
        _target.value = _target.value.copy(enabledReminder = value)
    }

    fun addTarget() {
        val target = _target.value
        val uuid = androidUuidGenerator.getOrCreateGuid()

        viewModelScope.launch(Dispatchers.IO) {
            try {
                if (target.targetName.isEmpty()
                    || target.category.isEmpty()
                    || target.targetAmount.toDouble() <= 0
                ) {
                    withContext(Dispatchers.Main) {
                        setToast("Fill all fields")
                    }
                } else {
                    repo.addTarget(
                        TargetDTO(
                            targetId = "",
                            uuid = uuid,
                            targetName = target.targetName,
                            targetDescription = target.targetDescription,
                            targetAmount = target.targetAmount.toLong(),
                            category = target.category,
                            date = 0L,
                            completed = false,
                            reminder = target.enabledReminder,
                        )
                    )
                    setIsNavigateStatus(true)
                }
            } catch (e: Exception) {
                withContext(Dispatchers.Main) {
                    setToast("Error adding target: ${e.message}")
                }
            }
        }
    }
}