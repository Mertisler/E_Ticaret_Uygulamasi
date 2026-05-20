package com.test.viewmodel

import app.cash.turbine.test
import com.google.common.truth.Truth.assertThat
import com.loc.eticaretuygulamasi.core.common.Resource
import com.loc.eticaretuygulamasi.feature.auth.domain.usecase.LoginUseCase
import com.loc.eticaretuygulamasi.feature.auth.presentation.AuthViewModel
import com.test.fake.FakeAuthRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class AuthViewModelTest {

    private lateinit var viewModel: AuthViewModel
    private val testDispatcher = StandardTestDispatcher()

    @Before
    fun setup() {
        Dispatchers.setMain(testDispatcher)

        val repository = FakeAuthRepository()
        val useCase = LoginUseCase(repository)

        viewModel = AuthViewModel(useCase)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun login_success_returnsSuccessState() = runTest {

        viewModel.loginState.test {


            val initialState = awaitItem()
            assertThat(initialState).isInstanceOf(Resource.Loading::class.java)

            viewModel.login("test", "123456")

            val successState = awaitItem()

            assertThat(successState).isInstanceOf(Resource.Success::class.java)

            cancelAndIgnoreRemainingEvents()
        }
    }
}