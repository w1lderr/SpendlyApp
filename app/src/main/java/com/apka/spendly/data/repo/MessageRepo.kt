package com.apka.spendly.data.repo

import com.apka.spendly.androidUuidGenerator.AndroidUuidGenerator
import com.apka.spendly.data.dto.MessageDTO
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody
import java.io.IOException

class MessageRepo(
    private val okHttpClient: OkHttpClient,
    private val androidUuidGenerator: AndroidUuidGenerator
) {
    private val uuid = androidUuidGenerator.getOrCreateGuid()
    private val json = Json { ignoreUnknownKeys = true }

    fun sendMessage(messageDTO: MessageDTO): String {
        val jsonBody = json.encodeToString(messageDTO.copy(uuid = uuid))

        val requestBody = jsonBody.toRequestBody("application/json".toMediaType())

        val request = Request.Builder()
            .url("http://10.0.2.2:8080/spendly/messages/sendMessage")
            .post(requestBody)
            .build()

        val response = okHttpClient.newCall(request).execute()
        return response.body?.string() ?: "Empty response body"
    }

    fun deleteMessages() {
        val request = Request.Builder()
            .url("http://10.0.2.2:8080/spendly/messages/deleteAllMessages?uuid=$uuid")
            .delete()
            .build()

        okHttpClient.newCall(request).execute().use { response ->
            if (!response.isSuccessful) throw IOException("Delete failed")
        }
    }

    fun getHistory(): List<MessageDTO> {
        val request = Request.Builder()
            .url("http://10.0.2.2:8080/spendly/messages/getChatHistory?uuid=$uuid")
            .get()
            .build()

        val response = okHttpClient.newCall(request).execute()

        if (!response.isSuccessful) throw IOException("History fetch failed")

        return Json.decodeFromString(response.body?.string() ?: "[]")
    }
}