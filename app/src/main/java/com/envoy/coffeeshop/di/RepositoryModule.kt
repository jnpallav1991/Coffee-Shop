package com.envoy.coffeeshop.di

import com.envoy.coffeeshop.data.repository.business.BusinessRepository
import com.envoy.coffeeshop.data.repository.business.BusinessRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    abstract fun bindCharacterRepository(
        characterRepositoryImpl: BusinessRepositoryImpl
    ): BusinessRepository
}