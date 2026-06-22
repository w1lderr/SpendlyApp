package com.apka.spendly.data.repo

import com.apka.spendly.data.dto.MonthlySummaryDTO
import kotlinx.serialization.json.Json
import okhttp3.OkHttpClient
import okhttp3.Request

class HomeRepo(private val okHttpClient: OkHttpClient) {
    fun getBalance(uuid: String): Long {
        val url = "http://46.101.188.243:8080/spendly/monobank/getBalance?uuid=$uuid"

        val request = Request.Builder()
            .url(url)
            .get()
            .build()

        okHttpClient.newCall(request).execute().use { response ->
            if (!response.isSuccessful) throw Exception("Unexpected code $response")

            val body = response.body.string().trim()
            return body.toLong()
        }
    }

    private val json = Json { ignoreUnknownKeys = true }

    fun getMonthlyCategories(uuid: String): MonthlySummaryDTO {
        val url = "http://46.101.188.243:8080/spendly/monobank/getMonthlyCategories?uuid=$uuid"

        val request = Request.Builder()
            .url(url)
            .get()
            .build()

        okHttpClient.newCall(request).execute().use { response ->
            if (!response.isSuccessful) throw Exception("Unexpected code $response")

            val body = response.body.string()
            return json.decodeFromString<MonthlySummaryDTO>(body)
        }
    }
}