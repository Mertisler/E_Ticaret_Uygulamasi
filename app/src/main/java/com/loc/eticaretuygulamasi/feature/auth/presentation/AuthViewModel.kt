package com.loc.eticaretuygulamasi.feature.auth.presentation

import com.loc.eticaretuygulamasi.core.datastore.TokenManager
import com.loc.eticaretuygulamasi.feature.auth.domain.usecase.LoginUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val loginUseCase: LoginUseCase,
    private val tokenManager: TokenManager
){
}