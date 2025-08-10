package com.apka.spendly.data.repo

import com.apka.spendly.data.dto.FinanceTipDTO
import kotlinx.serialization.json.Json
import okhttp3.OkHttpClient
import okhttp3.Request
import java.io.IOException

class FinanceTipsRepo(private val okHttpClient: OkHttpClient) {
    fun getFinanceTips(): List<FinanceTipDTO> {
        val request = Request.Builder()
            .url("http://10.0.2.2:8080/spendly/tips/get/finance/tips")
            .get()
            .build()

        val response = okHttpClient.newCall(request).execute()

        if (!response.isSuccessful) throw IOException("Failed to fetch finance tips")

        return Json.decodeFromString(response.body?.string() ?: "[]")
    }
}