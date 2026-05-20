package com.loc.eticaretuygulamasi.core.di

import com.loc.eticaretuygulamasi.feature.auth.data.repository.AuthRepositoryImpl
import com.loc.eticaretuygulamasi.feature.auth.domain.repository.AuthRepository
import com.loc.eticaretuygulamasi.feature.product.domain.repository.ProductRepository
import com.loc.eticaretuygulamasi.feature.product.domain.repository.ProductRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindAuthRepository(
        authRepositoryImpl: AuthRepositoryImpl
    ): AuthRepository

    @Binds
    @Singleton
    abstract fun bindProductRepository(
        productRepositoryImpl: ProductRepositoryImpl
    ): ProductRepository
}