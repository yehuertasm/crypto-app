package com.android.cryptoapp.uiModels

import com.android.cryptoapp.entities.data.Currency

data class DemoUIModel(
    val currencies: List<Currency> = emptyList()
)