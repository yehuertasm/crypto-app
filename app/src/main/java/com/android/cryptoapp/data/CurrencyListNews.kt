package com.android.cryptoapp.data

sealed class CurrencyListNews {
    data class ShowMessage(val currencyName: String) : CurrencyListNews()
}