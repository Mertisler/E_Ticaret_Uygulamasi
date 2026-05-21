package com.loc.eticaretuygulamasi.feature.auth.domain.repository

import com.loc.eticaretuygulamasi.feature.auth.data.remote.AuthApi
import com.loc.eticaretuygulamasi.feature.auth.data.remote.dto.LoginRequestDto
import com.loc.eticaretuygulamasi.feature.auth.domain.model.AuthResult
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val api: AuthApi
) : AuthRepository {

    override suspend fun login(username: String, password: String): AuthResult {

        val requestBody = LoginRequestDto(username = username, password = password)

        val response = api.login(requestBody)

        return AuthResult(
            token = response.token
        )
    }
}