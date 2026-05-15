package com.loc.eticaretuygulamasi.feature.auth.domain.usecase

import com.loc.eticaretuygulamasi.feature.auth.domain.repository.AuthRepository
import javax.inject.Inject

class LoginUseCase @Inject constructor(
    private val repository: AuthRepository

) {
    suspend operator fun invoke(
        username: String,
        password: String
    ) = repository.login(username, password
    )
}