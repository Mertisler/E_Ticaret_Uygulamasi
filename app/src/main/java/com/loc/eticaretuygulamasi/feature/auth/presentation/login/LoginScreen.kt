package com.loc.eticaretuygulamasi.feature.auth.presentation.login

import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.loc.eticaretuygulamasi.core.common.Resource
import com.loc.eticaretuygulamasi.feature.auth.presentation.AuthViewModel

@Composable
fun LoginScreen(
    viewModel: AuthViewModel = hiltViewModel(),
    onNavigateHome: () -> Unit
    )
{
        val loginState by viewModel.loginState.collectAsState()

    LaunchedEffect(loginState) {
        if (loginState is Resource.Success) {
            onNavigateHome()
        }
    }

    when (loginState) {
        is Resource.Loading -> {

            CircularProgressIndicator()
        }
        else -> {

            Button(
                onClick = {
                    viewModel.login("mor_2314", "83r5^_")
                }
            ) {
                Text("Login")
            }
        }
    }
}

