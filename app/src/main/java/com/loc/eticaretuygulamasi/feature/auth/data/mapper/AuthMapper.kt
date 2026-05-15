package com.loc.eticaretuygulamasi.feature.auth.data.mapper

import com.loc.eticaretuygulamasi.feature.auth.data.remote.dto.LoginResponseDto
import com.loc.eticaretuygulamasi.feature.auth.domain.model.AuthResult

fun LoginResponseDto.toDomain(): AuthResult {
    return AuthResult(
        token = token
    )
}