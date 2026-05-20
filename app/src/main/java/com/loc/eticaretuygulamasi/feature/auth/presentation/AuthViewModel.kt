package com.loc.eticaretuygulamasi.feature.auth.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.loc.eticaretuygulamasi.core.common.Resource
import com.loc.eticaretuygulamasi.feature.auth.domain.usecase.LoginUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val loginUseCase: LoginUseCase
): ViewModel() {

    private val _loginState = MutableStateFlow<Resource<Unit>>(Resource.Loading())

    val loginState: StateFlow<Resource<Unit>> = _loginState.asStateFlow()

    fun login(username: String, password: String) {
        viewModelScope.launch {
            _loginState.value = Resource.Loading()
            try {
                loginUseCase(username, password)
                _loginState.value = Resource.Success(Unit)
            } catch (e: Exception) {
                _loginState.value = Resource.Error(e.message ?: "Bir hata oluştu")
            }
        }
    }
}