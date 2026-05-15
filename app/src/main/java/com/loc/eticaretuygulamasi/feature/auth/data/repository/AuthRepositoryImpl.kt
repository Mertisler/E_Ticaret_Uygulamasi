package com.loc.eticaretuygulamasi.feature.auth.data.repository

import com.loc.eticaretuygulamasi.core.datastore.TokenManager
import com.loc.eticaretuygulamasi.feature.auth.data.mapper.toDomain
import com.loc.eticaretuygulamasi.feature.auth.data.remote.AuthApi
import com.loc.eticaretuygulamasi.feature.auth.data.remote.dto.LoginRequestDto
import com.loc.eticaretuygulamasi.feature.auth.domain.model.AuthResult
import com.loc.eticaretuygulamasi.feature.auth.domain.repository.AuthRepository
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val api: AuthApi,
    private val tokenManager: TokenManager

)  : AuthRepository {

    override suspend fun login(
        username: String,
        password: String
    ): AuthResult {

        val response = api.login(
            LoginRequestDto(
                username = username,
                password = password
            )
        )

        tokenManager.saveToken(response.token)

        return response.toDomain()
    }
}