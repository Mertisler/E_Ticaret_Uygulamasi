package com.loc.eticaretuygulamasi.feature.auth.data.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class LoginResponseDto(
    val token: String
)
