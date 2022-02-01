package com.android.cryptoapp.repositories

import com.android.cryptoapp.entities.data.Currency
import com.android.cryptoapp.entities.interfaces.CurrencyRepository
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class CurrencyRepositoryImpl @Inject constructor(
    private val currencyLocalDataSource: CurrencyLocalDataSource
) : CurrencyRepository {
    override fun getCurrencies(): Single<List<Currency>> {
        return currencyLocalDataSource.getCurrencies()
    }
}