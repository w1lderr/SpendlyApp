package com.apka.spendly.data.repo

import com.apka.spendly.androidUuidGenerator.AndroidUuidGenerator
import com.apka.spendly.data.dto.MessageDTO
import com.apka.spendly.data.model.Message
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody
import java.io.IOException

class MessageRepo(
    private val okHttpClient: OkHttpClient,
    androidUuidGenerator: AndroidUuidGenerator
) {
    private val uuid = androidUuidGenerator.getOrCreateGuid()
    private val json = Json { ignoreUnknownKeys = true }

    fun stopGeneration(): String {
        val request = Request.Builder()
            .url("http://46.101.188.243:8080/spendly/messages/stopGeneration?uuid=$uuid")
            .post("".toRequestBody())
            .build()

        val response = okHttpClient.newCall(request).execute()
        return response.body.string()
    }

    fun sendMessage(message: Message): String {
        val jsonBody = json.encodeToString(message.copy(uuid = uuid))

        val requestBody = jsonBody.toRequestBody("application/json".toMediaType())

        val request = Request.Builder()
            .url("http://46.101.188.243:8080/spendly/messages/sendMessage")
            .post(requestBody)
            .build()

        val response = okHttpClient.newCall(request).execute()
        return response.body.string()
    }

    fun deleteMessages() {
        val request = Request.Builder()
            .url("http://46.101.188.243:8080/spendly/messages/deleteAllMessages?uuid=$uuid")
            .delete()
            .build()

        okHttpClient.newCall(request).execute().use { response ->
            if (!response.isSuccessful) throw IOException("Delete failed")
        }
    }

    fun getHistory(): List<MessageDTO> {
        val request = Request.Builder()
            .url("http://46.101.188.243:8080/spendly/messages/getChatHistory?uuid=$uuid")
            .get()
            .build()

        val response = okHttpClient.newCall(request).execute()

        if (!response.isSuccessful) throw IOException("History fetch failed")

        return Json.decodeFromString(response.body.string())
    }
}