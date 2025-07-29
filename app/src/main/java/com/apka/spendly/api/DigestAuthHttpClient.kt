package com.apka.spendly.api

import com.burgstaller.okhttp.digest.Credentials
import com.burgstaller.okhttp.digest.DigestAuthenticator
import okhttp3.OkHttpClient
import java.util.concurrent.ConcurrentHashMap

class DigestAuthHttpClient(
    username: String,
    password: String
) {
    val client: OkHttpClient

    init {
        val authenticator = DigestAuthenticator(Credentials(username, password))

        val authCache = ConcurrentHashMap<String, String>()

        client = OkHttpClient.Builder()
            .authenticator(authenticator)
            .build()
    }
}