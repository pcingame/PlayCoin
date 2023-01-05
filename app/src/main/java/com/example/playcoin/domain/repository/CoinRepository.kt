package com.example.playcoin.domain.repository

import com.example.playcoin.data.data_source.dto.coinDetailDTO.CoinDetailDTO
import com.example.playcoin.data.data_source.dto.coinListDTO.CoinListDTO

interface CoinRepository {
    suspend fun getAllCoin(page: String): CoinListDTO

    suspend fun getCoinById(id: String): CoinDetailDTO
}