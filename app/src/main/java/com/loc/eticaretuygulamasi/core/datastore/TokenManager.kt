package com.loc.eticaretuygulamasi.core.datastore

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences // Doğru sınıf eklendi
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import com.loc.eticaretuygulamasi.core.common.Constants
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

class TokenManager @Inject constructor(
    private val dataStore: DataStore<Preferences>
) {

    private val tokenKey = stringPreferencesKey(Constants.TOKEN_KEY)

    suspend fun saveToken(token: String) {
        dataStore.edit { preferences ->
            preferences[tokenKey] = token
        }
    }

    fun getToken(): String? {
        return runBlocking {
            dataStore.data
                .map { preferences ->
                    preferences[tokenKey]
                }
                .first()
        }
    }
}