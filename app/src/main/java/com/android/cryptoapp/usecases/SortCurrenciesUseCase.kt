package com.android.cryptoapp.usecases

import com.android.cryptoapp.entities.data.Currency
import com.android.cryptoapp.others.SingleUseCase
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class SortCurrenciesUseCase @Inject constructor() :
    SingleUseCase<List<@kotlin.jvm.JvmSuppressWildcards Currency>, List<@kotlin.jvm.JvmSuppressWildcards Currency>>() {
    override fun execute(input: List<Currency>): Single<List<Currency>> {
        return Single.just(
            input.sortedBy {
                it.symbol
            }
        )
    }
}