package com.apka.spendly.data.repo

import com.apka.spendly.data.model.Exchange
import kotlinx.serialization.json.Json
import okhttp3.OkHttpClient
import okhttp3.Request
import java.io.IOException

class ExchangeRepo(private val okHttpClient: OkHttpClient) {
    fun getExchangeRatesByNBU(): List<Exchange> {
        val request = Request.Builder()
            .url("https://bank.gov.ua/NBUStatService/v1/statdirectory/exchange?json")
            .get()
            .build()

        val response = okHttpClient.newCall(request).execute()

        if (!response.isSuccessful) throw IOException("Failed to fetch exchange rates")

        return Json.decodeFromString(response.body.string())
    }
}