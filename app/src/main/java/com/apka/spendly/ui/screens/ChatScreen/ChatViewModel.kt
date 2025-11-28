package com.apka.spendly.ui.screens.ChatScreen

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.apka.spendly.androidUuidGenerator.AndroidUuidGenerator
import com.apka.spendly.data.dto.MessageDTO
import com.apka.spendly.data.model.Message
import com.apka.spendly.data.repo.MessageRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlinx.serialization.json.Json
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import okhttp3.WebSocket
import okhttp3.WebSocketListener
import java.util.UUID

class ChatViewModel(
    private val repo: MessageRepo,
    private val okHttpClient: OkHttpClient,
    androidUuidGenerator: AndroidUuidGenerator
) : ViewModel() {
    private val _message = MutableStateFlow("")
    private val uuid = androidUuidGenerator.getOrCreateGuid()
    private val _uiState = MutableStateFlow(ChatUiState())
    private val _isLoading = MutableStateFlow(false)
    private var webSocket: WebSocket? = null
    private var currentSendJob: Job? = null

    val uiState: StateFlow<ChatUiState> get() = _uiState
    val message: StateFlow<String> get() = _message
    val isLoading: StateFlow<Boolean> get() = _isLoading

    init {
        loadHistory()
    }

    fun setToast(value: String) {
        _uiState.value = _uiState.value.copy(toast = value)
    }

    fun onMessageChange(value: String) {
        if (!_isLoading.value) {
            _message.value = value
        }
    }

    fun sendMessage() {
        val currentMessage = _message.value
        if (currentMessage.isEmpty() || _isLoading.value) return

        // Set loading state immediately
        _isLoading.value = true

        // Clear input field
        _message.value = ""

        // Add user message to UI immediately
        val userMessage = MessageDTO(
            messageId = UUID.randomUUID().toString(),
            uuid = uuid,
            sender = "user",
            content = currentMessage,
            timestamp = System.currentTimeMillis()
        )
        _uiState.value = _uiState.value.copy(
            messages = _uiState.value.messages + userMessage
        )

        currentSendJob = viewModelScope.launch(Dispatchers.IO) {
            try {
                // Send message to server
                repo.sendMessage(
                    Message(
                        uuid = uuid,
                        sender = "user",
                        content = currentMessage,
                    )
                )

                // Set a timeout - if no AI response comes within 60 seconds, stop loading
                delay(120000) // 120 seconds timeout

                if (_isLoading.value) {
                    // Still loading after 60 seconds, something went wrong
                    withContext(Dispatchers.Main) {
                        _isLoading.value = false
                        // Check if AI response was saved to database but not received via WebSocket
                        checkForMissedMessages()
                        setToast("Response took longer than expected. Please check your connection.")
                    }
                }

            } catch (e: Exception) {
                withContext(Dispatchers.Main) {
                    _isLoading.value = false
                    setToast("Error: ${e.message}")
                }
            }
        }
    }

    fun stopGeneration() {
        currentSendJob?.cancel()
        currentSendJob = null
        _isLoading.value = false

        // Send a stop request to the server
        viewModelScope.launch(Dispatchers.IO) {
            try {
                repo.stopGeneration()
            } catch (e: Exception) {
                withContext(Dispatchers.Main) {
                    setToast("Error stopping generation: ${e.message}")
                }
            }
        }
    }

    fun deleteMessages() {
        if (_isLoading.value) return

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
                try {
                    val msg = Json.decodeFromString<MessageDTO>(text)

                    // Only add AI messages to avoid duplicates (user messages are added immediately)
                    if (msg.sender == "AI") {
                        _uiState.value = _uiState.value.copy(
                            messages = _uiState.value.messages + msg
                        )
                        // Turn off loading when AI responds
                        _isLoading.value = false
                    }
                } catch (e: Exception) {
                    Log.e("WEBSOCKET", "Error parsing message: ${e.message}")
                    _isLoading.value = false
                }
            }

            override fun onFailure(webSocket: WebSocket, t: Throwable, response: Response?) {
                Log.e("WEBSOCKET", "WebSocket failed: ${t.message}")
                _isLoading.value = false

                // Try to reconnect after a delay
                viewModelScope.launch {
                    delay(3000) // Wait 3 seconds
                    if (_uiState.value.messages.isNotEmpty()) {
                        // Only try to get missing messages if we have a conversation going
                        checkForMissedMessages()
                    }
                    connectToSocket()
                }
            }

            override fun onClosed(webSocket: WebSocket, code: Int, reason: String) {
                Log.i("WEBSOCKET", "WebSocket closed: $reason")
                _isLoading.value = false
            }

            override fun onOpen(webSocket: WebSocket, response: Response) {
                Log.i("WEBSOCKET", "WebSocket opened successfully")
            }
        })
    }

    // Add this new method to check for missed messages
    private suspend fun checkForMissedMessages() {
        try {
            val currentMessages = _uiState.value.messages
            val latestTimestamp = currentMessages.maxOfOrNull { it.timestamp } ?: 0

            // Get fresh history from server
            val serverHistory = repo.getHistory()

            // Find any messages we missed
            val missedMessages = serverHistory.filter { it.timestamp > latestTimestamp }

            if (missedMessages.isNotEmpty()) {
                withContext(Dispatchers.Main) {
                    _uiState.value = _uiState.value.copy(
                        messages = currentMessages + missedMessages
                    )
                    _isLoading.value = false
                }
            }
        } catch (e: Exception) {
            Log.e("WEBSOCKET", "Error checking for missed messages: ${e.message}")
            withContext(Dispatchers.Main) {
                _isLoading.value = false
            }
        }
    }

    fun closeConnection() {
        currentSendJob?.cancel()
        webSocket?.close(1000, "Closed by user")
        _isLoading.value = false
        Log.i("WEBSOCKET", "WebSocket connection closed")
    }

    override fun onCleared() {
        super.onCleared()
        closeConnection()
    }
}