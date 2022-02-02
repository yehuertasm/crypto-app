package com.android.cryptoapp.data

sealed class DemoNews {
    data class ShowMessage(val message: String) : DemoNews()
}