package com.example.playcoin.data.repository

import com.example.playcoin.data.CoinGeckoApi
import com.example.playcoin.data.data_source.dto.coinListDTO.CoinListDTO
import com.example.playcoin.domain.repository.CoinRepository
import com.example.playcoin.data.data_source.dto.coinDetailDTO.CoinDetailDTO
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val api: CoinGeckoApi
) : CoinRepository {
    override suspend fun getAllCoin(page: String): CoinListDTO {
        return api.getAllCoins(page = page)
    }

    override suspend fun getCoinById(id: String): CoinDetailDTO {
        return api.getCoinById(id = id)
    }
}