package com.android.cryptoapp.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "currencies")
data class CurrencyRoom(
    @PrimaryKey val id: String,
    @ColumnInfo val name: String,
    @ColumnInfo val symbol: String
)