package com.loc.eticaretuygulamasi.feature.auth.domain.repository

import com.loc.eticaretuygulamasi.feature.auth.domain.model.AuthResult

interface AuthRepository {
    suspend fun login(
        username: String,
        password: String
    ): AuthResult
}