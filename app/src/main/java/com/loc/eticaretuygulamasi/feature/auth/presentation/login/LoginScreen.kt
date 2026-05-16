package com.loc.eticaretuygulamasi.feature.auth.presentation.login

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.loc.eticaretuygulamasi.feature.auth.presentation.AuthViewModel

@Composable
fun LoginScreen(
    viewModel: AuthViewModel = hiltViewModel()
) {
    Button(
        onClick = {
            viewModel.login("mert", "123456")
        }
    ) {
        Text("Login")
    }
}
@Preview
@Composable
fun LoginScreenPreview() {
    LoginScreen()
}