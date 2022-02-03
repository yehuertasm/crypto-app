package com.android.cryptoapp.data

sealed class CurrencyEvent {
    data class CurrencySelected(
        val name: String
    ) : CurrencyEvent()
}