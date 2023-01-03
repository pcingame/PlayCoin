package com.example.playcoin.presentation.coinlist

import com.example.playcoin.domain.model.Coin

data class CoinListState(
    val isLoading: Boolean = false,
    val coinList: List<Coin> = emptyList(),
    val error: String = ""
)
