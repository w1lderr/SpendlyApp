package com.apka.spendly.data.repo

import com.apka.spendly.androidUuidGenerator.AndroidUuidGenerator
import com.apka.spendly.data.dto.TargetDTO
import com.apka.spendly.data.dto.TargetTopUpHistoryDTO
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody
import java.io.IOException

class TargetRepo(
    private val okHttpClient: OkHttpClient,
    androidUuidGenerator: AndroidUuidGenerator
) {
    private val uuid = androidUuidGenerator.getOrCreateGuid()
    private val json = Json { ignoreUnknownKeys = true }

    fun addTarget(targetDTO: TargetDTO) {
        val jsonBody = json.encodeToString(targetDTO)
        val requestBody = jsonBody.toRequestBody("application/json".toMediaType())

        val request = Request.Builder()
            .url("http://10.0.2.2:8080/spendly/target/addTarget")
            .post(requestBody)
            .build()

        okHttpClient.newCall(request).execute()
    }

    fun getTargets(): List<TargetDTO> {
        val request = Request.Builder()
            .url("http://10.0.2.2:8080/spendly/target/getTargets?uuid=$uuid")
            .get()
            .build()

        val response = okHttpClient.newCall(request).execute()

        if (!response.isSuccessful) throw IOException("Targets fetch failed")

        return Json.decodeFromString(response.body.string())
    }

    fun addContribution(targetTopUpHistoryDTO: TargetTopUpHistoryDTO): Int {
        val jsonBody = json.encodeToString(targetTopUpHistoryDTO)
        val requestBody = jsonBody.toRequestBody("application/json".toMediaType())

        val request = Request.Builder()
            .url("http://10.0.2.2:8080/spendly/contribution/addContribution")
            .post(requestBody)
            .build()

        val result = okHttpClient.newCall(request).execute()
        return result.code
    }

    fun getTargetTopUpHistory(targetId: String): List<TargetTopUpHistoryDTO> {
        val request = Request.Builder()
            .url("http://10.0.2.2:8080/spendly/contribution/getTopUpHistory?targetId=$targetId")
            .get()
            .build()

        val response = okHttpClient.newCall(request).execute()

        if (!response.isSuccessful) throw IOException("Top-up history fetch failed")

        return Json.decodeFromString(response.body.string())
    }

    fun getTotalTopUpAmount(targetId: String): Long {
        val request = Request.Builder()
            .url("http://10.0.2.2:8080/spendly/target/getTotalTopUpAmount?targetId=$targetId")
            .get()
            .build()

        val response = okHttpClient.newCall(request).execute()

        if (!response.isSuccessful) throw IOException("Total top-up amount fetch failed")

        val responseBody = response.body.string()

        return responseBody.toLong()
    }
}