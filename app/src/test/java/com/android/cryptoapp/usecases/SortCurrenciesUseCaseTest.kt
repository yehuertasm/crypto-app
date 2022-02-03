package com.android.cryptoapp.usecases

import com.android.cryptoapp.entities.data.Currency
import io.mockk.junit5.MockKExtension
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(MockKExtension::class)
class SortCurrenciesUseCaseTest {

    private lateinit var useCase: SortCurrenciesUseCase

    @BeforeEach
    fun setUp() {
        useCase = SortCurrenciesUseCase()
    }

    @Test
    fun `Should return a list sorted by symbol of currencies`() {
        // given
        val currenciesList = listOf(
            mockCurrency("LTC", "Litecoin", "LTC"),
            mockCurrency("BTC", "Bitcoin", "BTC"),
            mockCurrency("ETH", "Ethereum", "ETH"),
            mockCurrency("XRP", "XRP", "XRP")
        )

        val sortedList = listOf(
            mockCurrency("BTC", "Bitcoin", "BTC"),
            mockCurrency("ETH", "Ethereum", "ETH"),
            mockCurrency("LTC", "Litecoin", "LTC"),
            mockCurrency("XRP", "XRP", "XRP")
        )

        // when
        val testObserver = useCase.execute(currenciesList).test()

        // then
        testObserver.assertNoErrors()
        testObserver.assertResult(sortedList)
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