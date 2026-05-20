package com.test.repository

import com.test.fake.FakeProductRepository
import org.junit.Before
import org.junit.Test
import kotlinx.coroutines.test.runTest
import com.google.common.truth.Truth.assertThat

class ProductRepositoryTest {

    private lateinit var repository: FakeProductRepository

    @Before
    fun setup() {

        repository = FakeProductRepository()
    }

    @Test
    fun getProductById_returnsCorrectProduct() = runTest {

        val product = repository.getProductById(1)

        assertThat(product.title)
            .isEqualTo("iPhone")
    }
}