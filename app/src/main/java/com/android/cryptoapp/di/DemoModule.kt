package com.android.cryptoapp.di

import com.android.cryptoapp.data.CryptoAppResources
import com.android.cryptoapp.entities.interfaces.AppResources
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DemoModule {
    @Binds
    abstract fun bindResources(cryptoAppResources: CryptoAppResources): AppResources
}