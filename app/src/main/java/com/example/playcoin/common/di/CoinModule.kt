package com.example.playcoin.common.di

import com.example.playcoin.common.Constant.BASE_URL
import com.example.playcoin.data.CoinGeckoApi
import com.example.playcoin.data.repository.CoinRepositoryImpl
import com.example.playcoin.domain.repository.CoinRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object CoinModule {

    @Provides
    @Singleton
    fun provideCoinGeckoApi(): CoinGeckoApi {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CoinGeckoApi::class.java)
    }

    @Provides
    @Singleton
    fun provideCoinGeckoRepository(api: CoinGeckoApi): CoinRepository{
        return CoinRepositoryImpl(api)
    }
}