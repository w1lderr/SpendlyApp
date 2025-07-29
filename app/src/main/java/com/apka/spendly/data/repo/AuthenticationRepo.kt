package com.apka.spendly.data.repo

import com.apka.spendly.data.preferences.AuthenticationPreferencesDataSource
import kotlinx.coroutines.flow.Flow

class AuthenticationRepo(
    private val dataSource: AuthenticationPreferencesDataSource
) {
    val isLoggedIn: Flow<Boolean> = dataSource.isLoggedInFlow

    suspend fun setLoggedIn(loggedIn: Boolean) {
        dataSource.setLoggedIn(loggedIn)
    }
}