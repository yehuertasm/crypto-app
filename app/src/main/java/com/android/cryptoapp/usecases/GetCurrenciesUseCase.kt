package com.android.cryptoapp.usecases

import com.android.cryptoapp.entities.data.Currency
import com.android.cryptoapp.entities.interfaces.CurrencyRepository
import com.android.cryptoapp.others.SingleUseCase
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class GetCurrenciesUseCase @Inject constructor(
    private val currencyRepository: CurrencyRepository
) : SingleUseCase<Unit, List<@kotlin.jvm.JvmSuppressWildcards Currency>>() {

    override fun execute(input: Unit): Single<List<Currency>> {
        return currencyRepository.getCurrencies()
    }
}