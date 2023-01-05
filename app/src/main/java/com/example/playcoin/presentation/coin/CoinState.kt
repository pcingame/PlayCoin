package com.example.playcoin.presentation.coin

import com.example.playcoin.domain.model.CoinDetail

data class CoinState(
    val isLoading: Boolean = false,
    val coinDetail: CoinDetail? = null,
    val error: String = ""
)
