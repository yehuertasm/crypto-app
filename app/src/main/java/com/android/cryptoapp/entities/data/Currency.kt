package com.android.cryptoapp.entities.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Currency(
    val id: String,
    val name: String,
    val symbol: String
): Parcelable