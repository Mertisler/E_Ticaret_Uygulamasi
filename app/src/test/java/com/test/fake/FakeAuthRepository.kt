package com.test.fake

import com.loc.eticaretuygulamasi.feature.auth.domain.model.AuthResult
import com.loc.eticaretuygulamasi.feature.auth.domain.repository.AuthRepository

class FakeAuthRepository : AuthRepository {

    override suspend fun login(
        username: String,
        password: String
    ): AuthResult {

        return AuthResult(
            token = "fake_token_123"
        )
    }
}