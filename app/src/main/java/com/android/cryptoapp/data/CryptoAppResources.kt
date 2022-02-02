package com.android.cryptoapp.data

import android.content.Context
import com.android.cryptoapp.entities.interfaces.AppResources
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class CryptoAppResources @Inject constructor(
    @ApplicationContext private val context: Context
) : AppResources {
    override fun getString(resId: Int): String {
        return context.getString(resId)
    }
}