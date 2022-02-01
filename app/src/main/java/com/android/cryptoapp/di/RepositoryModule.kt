package com.android.cryptoapp.di

import android.content.Context
import androidx.room.Room
import com.android.cryptoapp.data.CurrencyInfoDatabase
import com.android.cryptoapp.entities.interfaces.CurrencyRepository
import com.android.cryptoapp.repositories.CurrencyLocalDataSource
import com.android.cryptoapp.repositories.CurrencyRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {
    @Provides
    @Singleton
    fun providesCurrencyInfoRepository(
        @ApplicationContext context: Context,
    ): CurrencyRepository {
        val database =
            Room.databaseBuilder(context, CurrencyInfoDatabase::class.java, "database-currencies")
                .fallbackToDestructiveMigration()
                .createFromAsset("database/currencies.db")
                .build()

        val dao = database.currencyInfoDao()
        val dataSource = CurrencyLocalDataSource(dao)

        return CurrencyRepositoryImpl(dataSource)
    }
}