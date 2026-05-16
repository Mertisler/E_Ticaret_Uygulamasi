package com.loc.eticaretuygulamasi.feature.auth.presentation.register

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.loc.eticaretuygulamasi.feature.auth.presentation.AuthViewModel

@Composable
fun RegisterScreen(
    viewModel: AuthViewModel = hiltViewModel()
) {
    Text("Register Screen")
}
