package com.apka.spendly.data.repo

import com.apka.spendly.androidUuidGenerator.AndroidUuidGenerator
import com.apka.spendly.data.dto.TransactionDTO
import kotlinx.serialization.json.Json
import okhttp3.OkHttpClient
import okhttp3.Request

class TransactionRepo(
    private val okHttpClient: OkHttpClient,
    private val androidUuidGenerator: AndroidUuidGenerator
) {
    private val json = Json { ignoreUnknownKeys = true }
    private val uuid = androidUuidGenerator.getOrCreateGuid()

    fun fetchTransactions(): List<TransactionDTO> {
        val url = "http://10.0.2.2:8080/spendly/monobank/getTransactions?uuid=$uuid"

        val request = Request.Builder()
            .url(url)
            .get()
            .build()

        okHttpClient.newCall(request).execute().use { response ->
            if (!response.isSuccessful) {
                throw Exception("HTTP ${response.code}: ${response.message}")
            }

            val body = response.body?.string()
                ?: throw Exception("Empty response body")

            return json.decodeFromString(body)
        }
    }
}