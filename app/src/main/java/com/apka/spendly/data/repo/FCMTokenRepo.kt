package com.apka.spendly.data.repo

import com.apka.spendly.data.model.fcmToken
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody

class FCMTokenRepo(
    private val okHttpClient: OkHttpClient
) {
    private val json = Json { ignoreUnknownKeys = true }

    fun saveFcmToken(fcmToken: fcmToken): String {
        val jsonBody = json.encodeToString(fcmToken)

        val requestBody = jsonBody.toRequestBody("application/json".toMediaType())

        val request = Request.Builder()
            .url("http://10.0.2.2:8080/spendly/fcm/save/token")
            .post(requestBody)
            .build()

        val response = okHttpClient.newCall(request).execute()
        return response.body.string()
    }
}