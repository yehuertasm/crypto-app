package com.android.cryptoapp.di

import com.android.cryptoapp.data.CryptoAppResources
import com.android.cryptoapp.entities.data.Currency
import com.android.cryptoapp.entities.interfaces.AppResources
import com.android.cryptoapp.entities.qualifiers.GetCurrencies
import com.android.cryptoapp.others.SingleUseCase
import com.android.cryptoapp.usecases.GetCurrenciesUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DemoModule {

    @Binds
    @GetCurrencies
    abstract fun bindGetCurrenciesUseCase(getCurrenciesUseCase: GetCurrenciesUseCase): SingleUseCase<Unit, List<Currency>>

    @Binds
    abstract fun bindResources(cryptoAppResources: CryptoAppResources): AppResources
}