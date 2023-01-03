package com.example.playcoin.domain.repository

import com.example.playcoin.data.data_source.dto.CoinDetailDTO.CoinDetailDTO
import com.example.playcoin.data.data_source.dto.CoinListDTO.CoinListDTO

interface CoinRepository {
    suspend fun getAllCoin(page: String): CoinListDTO

    suspend fun getCoinById(id: String): CoinDetailDTO
}