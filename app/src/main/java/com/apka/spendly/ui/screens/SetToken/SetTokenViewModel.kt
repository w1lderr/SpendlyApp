package com.apka.spendly.ui.screens.SetToken

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.apka.spendly.androidUuidGenerator.AndroidUuidGenerator
import com.apka.spendly.data.dto.TokenDTO
import com.apka.spendly.data.repo.AuthenticationRepo
import com.apka.spendly.data.repo.TokenRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class SetTokenViewModel(
    private val tokenRepo: TokenRepo,
    private val authenticationRepo: AuthenticationRepo,
    private val uuidGenerator: AndroidUuidGenerator
) : ViewModel() {
    private val _token = MutableStateFlow("")
    private val _uiState = MutableStateFlow(SetTokenUiState())
    val token: StateFlow<String> = _token
    val uiState: StateFlow<SetTokenUiState> = _uiState

    fun setIsNavigateToHome(value: Boolean) {
        _uiState.value = _uiState.value.copy(navigateToHome = value)
    }

    fun setToken(token: String) {
        _token.value = token
    }

    fun setToast(toast: String) {
        _uiState.value = _uiState.value.copy(toast = toast)
    }

    fun setLoggedIn(loggedIn: Boolean) {
        viewModelScope.launch(Dispatchers.IO) {
            authenticationRepo.setLoggedIn(loggedIn)
        }
    }

    fun sendTokenRequest() {
        val uuid = uuidGenerator.getOrCreateGuid()
        val current_token = _token.value

        viewModelScope.launch(Dispatchers.IO) {
            try {
                if (current_token.isNotEmpty() && uuid.isNotEmpty()) {
                    setLoggedIn(true)
                    val response = tokenRepo.saveToken(
                        TokenDTO(
                            uuid = uuid,
                            token = current_token
                        )
                    )

                    withContext(Dispatchers.Main) {
                        setIsNavigateToHome(true)
                        setToast(response)
                    }
                } else {
                    withContext(Dispatchers.Main) {
                        setToast("Token is empty")
                    }
                }
            } catch (e: Exception) {
                withContext(Dispatchers.Main) {
                    setToast("Error: $e")
                }
            }
        }
    }
}