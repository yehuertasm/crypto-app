package com.android.cryptoapp.data

sealed class CurrencyEvent {
    object CurrencySelected: CurrencyEvent()
}