package com.test.viewmodel

import androidx.paging.testing.asSnapshot // EKLENMESİ GEREKEN IMPORT
import com.google.common.truth.Truth.assertThat
import com.loc.eticaretuygulamasi.feature.product.domain.usecase.GetProductsUseCase
import com.loc.eticaretuygulamasi.feature.product.presentation.ProductViewModel
import com.test.fake.FakeProductRepository
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test

class ProductViewModelTest {

    private lateinit var viewModel: ProductViewModel

    @Before
    fun setup() {
        val repository = FakeProductRepository()
        val useCase = GetProductsUseCase(repository)
        viewModel = ProductViewModel(useCase)
    }

    @Test
    fun productsFlow_emitsPagingData() = runTest {

        // 1. asSnapshot() ile PagingData'nın içindeki verileri temiz bir listeye çıkartıyoruz
        val items = viewModel.products.asSnapshot()

        // 2. Listenin boş olmadığını doğruluyoruz
        assertThat(items).isNotEmpty()

        // 3. FakeRepository'den gelen ilk ürünün beklediğimiz ürün olduğunu doğruluyoruz
        assertThat(items[0].title).isEqualTo("iPhone") // Fake repoda ne tanımladıysan onu yaz
    }
}