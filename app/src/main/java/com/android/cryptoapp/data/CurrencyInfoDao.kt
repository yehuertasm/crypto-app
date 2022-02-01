package com.android.cryptoapp.data

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import io.reactivex.rxjava3.core.Single

@Dao
interface CurrencyInfoDao {
    @Transaction
    @Query("SELECT * FROM currencies")
    fun getCurrencies(): Single<List<CurrencyRoom>>
}