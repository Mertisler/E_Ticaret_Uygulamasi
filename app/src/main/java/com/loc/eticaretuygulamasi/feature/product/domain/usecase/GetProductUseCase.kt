package com.loc.eticaretuygulamasi.feature.product.domain.usecase

import com.loc.eticaretuygulamasi.feature.product.domain.repository.ProductRepository
import javax.inject.Inject

class GetProductsUseCase @Inject constructor(
    private val repository: ProductRepository
) {

    operator fun invoke() =
        repository.getProducts()
}