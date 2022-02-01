package com.android.cryptoapp.repositories

import com.android.cryptoapp.data.CurrencyInfoDao
import com.android.cryptoapp.data.CurrencyRoom
import com.android.cryptoapp.entities.data.Currency
import com.android.cryptoapp.entities.interfaces.CurrencyDataSource
import io.reactivex.rxjava3.core.Single

class CurrencyLocalDataSource constructor(
    private val currencyDao: CurrencyInfoDao
): CurrencyDataSource {
    override fun getCurrencies(): Single<List<Currency>> {
        return currencyDao.getCurrencies().map { currencies ->
            currencies.map {
                it.toBaseModel()
            }
        }
    }
}

private fun CurrencyRoom.toBaseModel() : Currency {
    return Currency(
        id = id,
        name = name,
        symbol = symbol
    )
}