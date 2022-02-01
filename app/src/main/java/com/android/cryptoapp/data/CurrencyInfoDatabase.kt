package com.android.cryptoapp.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [CurrencyRoom::class], version = 1)
abstract class CurrencyInfoDatabase : RoomDatabase() {
    abstract fun currencyInfoDao(): CurrencyInfoDao
}