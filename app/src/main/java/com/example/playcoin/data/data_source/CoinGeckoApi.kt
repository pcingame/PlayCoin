package com.example.playcoin.data.data_source

import com.example.playcoin.data.data_source.dto.CoinDetailDTO.CoinDetailDTO
import com.example.playcoin.data.data_source.dto.CoinListDTO.CoinListDTO
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface CoinGeckoApi {
    @GET("/api/v3/coins/markets?vs_currency=usd&order=market_cap_desc&per_page=100&sparkline=false")
    suspend fun getAllCoins(@Query("page") page: String): CoinListDTO

    @GET("/api/v3/coins/{id}")
    suspend fun getCoinById(@Path("id") id: String): CoinDetailDTO
}