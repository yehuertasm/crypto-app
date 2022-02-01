package com.android.cryptoapp.entities.interfaces

import com.android.cryptoapp.entities.data.Currency
import io.reactivex.rxjava3.core.Single

interface CurrencyDataSource {
    fun getCurrencies(): Single<List<Currency>>
}