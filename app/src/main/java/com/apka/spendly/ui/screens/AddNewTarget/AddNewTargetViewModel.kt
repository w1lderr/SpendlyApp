package com.apka.spendly.ui.screens.AddNewTarget

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

    fun setToast(value: String) {
        _uiState.value = _uiState.value.copy(toast = value)
    }

    private fun setIsNavigateStatus() {
        _uiState.value = _uiState.value.copy(isNavigate = true)
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
                if (target.targetName.isEmpty()) {
                    withContext(Dispatchers.Main) {
                        setToast("Введіть назву цілі")
                    }
                    return@launch
                }

                if (target.category.isEmpty()) {
                    withContext(Dispatchers.Main) {
                        setToast("Оберіть категорію")
                    }
                    return@launch
                }

                val amountValue = target.targetAmount.toLongOrNull()
                if (amountValue == null || amountValue <= 0) {
                    withContext(Dispatchers.Main) {
                        setToast("Введіть коректну суму")
                    }
                    return@launch
                }

                val amountConverter = amountValue * 100

                repo.addTarget(
                    TargetDTO(
                        targetId = "",
                        uuid = uuid,
                        targetName = target.targetName,
                        targetDescription = target.targetDescription.ifEmpty { null },
                        targetAmount = amountConverter,
                        category = target.category,
                        date = 0L,
                        completed = false,
                        reminder = target.enabledReminder,
                    )
                )

                withContext(Dispatchers.Main) {
                    setToast("Ціль успішно додано")
                    setIsNavigateStatus()
                }
            } catch (e: Exception) {
                withContext(Dispatchers.Main) {
                    setToast("Помилка: ${e.message}")
                }
            }
        }
    }
}