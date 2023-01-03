package com.example.playcoin.data.repository

import com.example.playcoin.data.data_source.CoinGeckoApi
import com.example.playcoin.data.data_source.dto.CoinDetailDTO.CoinDetailDTO
import com.example.playcoin.data.data_source.dto.CoinListDTO.CoinListDTO
import com.example.playcoin.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val coinApi: CoinGeckoApi
) : CoinRepository {
    override suspend fun getAllCoin(page: String): CoinListDTO {
        return coinApi.getAllCoins(page = page)
    }

    override suspend fun getCoinById(id: String): CoinDetailDTO {
        return coinApi.getCoinById(id = id)
    }
}