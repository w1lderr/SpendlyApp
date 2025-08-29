package com.apka.spendly.data.repo

import com.apka.spendly.androidUuidGenerator.AndroidUuidGenerator
import com.apka.spendly.data.dto.ChallengeDTO
import com.apka.spendly.data.dto.JoinChallengeRequest
import com.apka.spendly.data.dto.UserChallengeDTO
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody
import java.io.IOException

class ChallengeRepo(
    private val okHttpClient: OkHttpClient,
    androidUuidGenerator: AndroidUuidGenerator
) {
    private val uuid = androidUuidGenerator.getOrCreateGuid()

    fun getUserChallenges(): List<UserChallengeDTO> {
        val request = Request.Builder()
            .url("http://10.0.2.2:8080/spendly/challenge/get/user/challenges?uuid=$uuid")
            .get()
            .build()

        val response = okHttpClient.newCall(request).execute()

        if (!response.isSuccessful) throw IOException("Failed to fetch challenges")

        return Json.decodeFromString(response.body?.string() ?: "[]")
    }

    fun getChallenges(): List<ChallengeDTO> {
        val request = Request.Builder()
            .url("http://10.0.2.2:8080/spendly/challenge/get/challenges")
            .get()
            .build()

        val response = okHttpClient.newCall(request).execute()

        if (!response.isSuccessful) throw IOException("Failed to fetch challenges")

        return Json.decodeFromString(response.body?.string() ?: "[]")
    }

    fun joinChallenge(challengeId: String): String {
        val jsonBody = Json.encodeToString(
            JoinChallengeRequest.serializer(),
            JoinChallengeRequest(uuid = uuid, challengeId = challengeId)
        )

        val requestBody = jsonBody.toRequestBody("application/json; charset=utf-8".toMediaType())

        val request = Request.Builder()
            .url("http://10.0.2.2:8080/spendly/challenge/joinChallenge")
            .post(requestBody)
            .build()

        val response = okHttpClient.newCall(request).execute()
        return response.body?.string() ?: "Empty response body"
    }
}