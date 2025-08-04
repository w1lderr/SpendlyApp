package com.apka.spendly.data.repo

import com.apka.spendly.data.dto.TokenDTO
import okhttp3.FormBody
import okhttp3.OkHttpClient
import okhttp3.Request

class TokenRepo(private val okHttpClient: OkHttpClient) {
    fun saveToken(tokenDTO: TokenDTO): String {
        val requestBody = FormBody.Builder()
            .add("uuid", tokenDTO.uuid)
            .add("token", tokenDTO.token)
            .build()

        val request = Request.Builder()
            .url("http://10.0.2.2:8080/spendly/monobank/token")
            .post(requestBody)
            .build()

        val response = okHttpClient.newCall(request).execute()
        return response.body?.string() ?: "Empty response body"
    }
}