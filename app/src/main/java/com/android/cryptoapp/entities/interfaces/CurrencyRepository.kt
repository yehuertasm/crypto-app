package com.android.cryptoapp.entities.interfaces

import com.android.cryptoapp.entities.data.Currency
import io.reactivex.rxjava3.core.Single

interface CurrencyRepository {
    fun getCurrencies(): Single<List<Currency>>
}