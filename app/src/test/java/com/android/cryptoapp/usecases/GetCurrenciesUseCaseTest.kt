package com.android.cryptoapp.usecases

import com.android.cryptoapp.entities.data.Currency
import com.android.cryptoapp.entities.interfaces.CurrencyRepository
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.junit5.MockKExtension
import io.reactivex.rxjava3.core.Single
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import java.lang.Exception

@ExtendWith(MockKExtension::class)
class GetCurrenciesUseCaseTest {

    @MockK(relaxed = true)
    private lateinit var currencyRepository: CurrencyRepository

    private lateinit var useCase: GetCurrenciesUseCase

    @BeforeEach
    fun setUp() {
        useCase = GetCurrenciesUseCase(currencyRepository)
    }

    @Test
    fun `Should return a list of currencies`() {
        // given
        val currenciesList = listOf(
            mockCurrency("BTC", "Bitcoin", "BTC"),
            mockCurrency("CRO", "Crypto.com Chain", "CRO")
        )

        every {
            currencyRepository.getCurrencies()
        } returns Single.just(currenciesList)

        // when
        val testObserver = useCase.execute(Unit).test()

        // then
        testObserver.assertNoErrors()
        testObserver.assertResult(currenciesList)
    }

    @Test
    fun `Should return an error when can not get the currencies list from the repository`() {
        // given
        val error = Exception("Can not get data from the repository")

        every {
            currencyRepository.getCurrencies()
        } returns Single.error(error)

        // when
        val testObserver = useCase.execute(Unit).test()

        // then
        testObserver.assertError(error)
    }
}

private fun mockCurrency(
    id: String,
    name: String,
    symbol: String
): Currency {
    return Currency(
        id = id,
        name = name,
        symbol = symbol
    )
}