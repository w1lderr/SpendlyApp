package com.apka.spendly.data.preferences

import android.content.Context
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

private val Context.dataStore by preferencesDataStore(name = "authentaction_status")

class AuthenticationPreferencesDataSource(private val context: Context) {
    private val IS_LOGGED_IN = booleanPreferencesKey("is_logged_in")

    val isLoggedInFlow: Flow<Boolean> = context.dataStore.data
        .map { preferences -> preferences[IS_LOGGED_IN] ?: false }

    suspend fun setLoggedIn(loggedIn: Boolean) {
        context.dataStore.edit { prefs ->
            prefs[IS_LOGGED_IN] = loggedIn
        }
    }
}