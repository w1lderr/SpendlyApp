package com.apka.spendly.data.repo

import com.apka.spendly.androidUuidGenerator.AndroidUuidGenerator
import com.apka.spendly.data.dto.ChallengeStatisticDTO
import kotlinx.serialization.json.Json
import okhttp3.OkHttpClient
import okhttp3.Request

class StatisticRepo(
    private val okHttpClient: OkHttpClient,
    androidUuidGenerator: AndroidUuidGenerator
) {
    private val uuid = androidUuidGenerator.getOrCreateGuid()
    private val json = Json { ignoreUnknownKeys = true }


    fun getChallengesStat(period: String): ChallengeStatisticDTO {
        val url = "http://46.101.188.243:8080/spendly/challenges/statistics?uuid=$uuid&period=$period"

        val request = Request.Builder()
            .url(url)
            .get()
            .build()

        okHttpClient.newCall(request).execute().use { response ->
            if (!response.isSuccessful) {
                throw Exception("HTTP ${response.code}: ${response.message}")
            }

            val body = response.body.string()
            return json.decodeFromString(body)
        }
    }
}