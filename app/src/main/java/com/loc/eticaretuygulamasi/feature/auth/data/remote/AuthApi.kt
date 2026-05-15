package com.loc.eticaretuygulamasi.feature.auth.data.remote

import com.loc.eticaretuygulamasi.feature.auth.data.remote.dto.LoginRequestDto
import com.loc.eticaretuygulamasi.feature.auth.data.remote.dto.LoginResponseDto
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthApi {

    @POST("auth/login")
    suspend fun login(
        @Body request: LoginRequestDto
    ): LoginResponseDto
}