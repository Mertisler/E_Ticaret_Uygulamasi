package com.loc.eticaretuygulamasi.feature.product.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.loc.eticaretuygulamasi.feature.product.domain.usecase.GetProductsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ProductViewModel @Inject constructor(
    getProductsUseCase: GetProductsUseCase
) : ViewModel() {

    val products =
        getProductsUseCase()
            .cachedIn(viewModelScope)
}