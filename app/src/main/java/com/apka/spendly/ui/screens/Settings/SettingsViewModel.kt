package com.apka.spendly.ui.screens.Settings

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.apka.spendly.data.preferences.AuthenticationPreferencesDataSource
import com.apka.spendly.data.repo.AuthenticationRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class SettingsViewModel(private val repo: AuthenticationRepo): ViewModel() {
    private val _uiState = MutableStateFlow(SettingsUiState())
    val uiState: StateFlow<SettingsUiState> get() = _uiState

    fun setToast(value: String) {
        _uiState.value = _uiState.value.copy(toast = value)
    }

    fun logout() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                repo.setLoggedIn(false)
                delay(2000)
                withContext(Dispatchers.Main) {
                    setToast("Logged out successfully")
                    _uiState.value = _uiState.value.copy(navigateToGetStarted = true)
                }
            } catch (e: Exception) {
                withContext(Dispatchers.Main) {
                    setToast("Error logging out: ${e.message}")
                }
            }
        }
    }
}