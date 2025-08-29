package com.apka.spendly.ui.screens.SetToken

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.apka.spendly.androidUuidGenerator.AndroidUuidGenerator
import com.apka.spendly.data.dto.FCMTokenDTO
import com.apka.spendly.data.dto.TokenDTO
import com.apka.spendly.data.repo.AuthenticationRepo
import com.apka.spendly.data.repo.FCMTokenRepo
import com.apka.spendly.data.repo.TokenRepo
import com.google.firebase.messaging.FirebaseMessaging
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class SetTokenViewModel(
    private val tokenRepo: TokenRepo,
    private val authenticationRepo: AuthenticationRepo,
    private val fcmTokenRepo: FCMTokenRepo,
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

    fun setIsTermsOfUseAgreed(isAgreed: Boolean) {
        _uiState.value = _uiState.value.copy(isTermsOfUseAgreed = isAgreed)
    }

    private fun setFcmToken() {
        FirebaseMessaging.getInstance().token.addOnCompleteListener { task ->
            if (!task.isSuccessful) {
                Log.w("FCM", "Fetching FCM token failed", task.exception)
                return@addOnCompleteListener
            }

            val token = task.result
            Log.d("FCM", "Device FCM token: $token")

            viewModelScope.launch(Dispatchers.IO) {
                try {
                    fcmTokenRepo.saveFcmToken(
                        FCMTokenDTO(
                            fcmTokenId = "",
                            uuid = uuidGenerator.getOrCreateGuid(),
                            fcmToken = token
                        )
                    )
                } catch (e: Exception) {
                    withContext(Dispatchers.Main) {
                        setToast("Error saving FCM token: $e")
                    }
                }
            }
        }
    }

    fun sendTokenRequest() {
        val uuid = uuidGenerator.getOrCreateGuid()
        val current_token = _token.value

        viewModelScope.launch(Dispatchers.IO) {
            try {
                if (current_token.isNotEmpty() && current_token.length > 36) {
                    setFcmToken()
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
                        setToast("Token is empty or not valid")
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