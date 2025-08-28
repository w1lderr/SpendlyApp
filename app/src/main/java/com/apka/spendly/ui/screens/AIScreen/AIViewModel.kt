package com.apka.spendly.ui.screens.AIScreen

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.apka.spendly.androidUuidGenerator.AndroidUuidGenerator
import com.apka.spendly.data.dto.MessageDTO
import com.apka.spendly.data.repo.MessageRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlinx.serialization.json.Json
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.WebSocket
import okhttp3.WebSocketListener

class AIViewModel(
    private val repo: MessageRepo,
    private val okHttpClient: OkHttpClient,
    uuidGenerator: AndroidUuidGenerator
) : ViewModel() {
    private val _message = MutableStateFlow("")
    private val uuid = uuidGenerator.getOrCreateGuid()
    private val _uiState = MutableStateFlow(AIUiState())
    private var webSocket: WebSocket? = null
    val uiState: StateFlow<AIUiState> get() = _uiState
    val message: StateFlow<String> get() = _message

    init {
        loadHistory()
    }

    fun setToast(value: String) {
        _uiState.value = _uiState.value.copy(toast = value)
    }

    fun onMessageChange(value: String) {
        _message.value = value
    }

    fun sendMessage() {
        val currentMessage = _message.value
        viewModelScope.launch(Dispatchers.IO) {
            try {
                _message.value = ""
                repo.sendMessage(
                    MessageDTO(
                        messageId = "",
                        uuid = uuid,
                        sender = "user",
                        content = currentMessage,
                        timestamp = 0L
                    )
                )
            } catch (e: Exception) {
                withContext(Dispatchers.Main) {
                    setToast("Error: ${e.message}")
                }
            }
        }
    }

    fun deleteMessages() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                repo.deleteMessages()
                _uiState.value = _uiState.value.copy(messages = emptyList())
            } catch (e: Exception) {
                withContext(Dispatchers.Main) {
                    setToast("Error: ${e.message}")
                }
            }
        }
    }

    fun loadHistory() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val history = repo.getHistory()
                _uiState.value = _uiState.value.copy(messages = history)
            } catch (e: Exception) {
                withContext(Dispatchers.Main) {
                    setToast("Failed to load chat history: ${e.message}")
                }
            }
        }
    }

    fun connectToSocket() {
        val request = Request.Builder()
            .url("ws://10.0.2.2:8080/spendly/messages/stream?uuid=${uuid}")
            .build()

        webSocket = okHttpClient.newWebSocket(request, object : WebSocketListener() {
            override fun onMessage(webSocket: WebSocket, text: String) {
                val msg = Json.decodeFromString<MessageDTO>(text)
                _uiState.value = _uiState.value.copy(
                    messages = _uiState.value.messages + msg
                )
            }
        })
        Log.i("WEBSOCKET", "WebSocket connection opened")
    }

    fun closeConnection() {
        webSocket?.close(1000, "Closed by user")
        Log.i("WEBSOCKET", "WebSocket connection closed")
    }
}