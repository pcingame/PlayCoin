package com.example.playcoin.domain.use_case

import com.example.playcoin.common.utils.ResponseState
import com.example.playcoin.domain.model.Coin
import com.example.playcoin.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class CoinListUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    operator fun invoke(page: String): Flow<ResponseState<List<Coin>>> = flow {
        try {
            emit(ResponseState.Loading<List<Coin>>())
            val coins = repository.getAllCoin(page).map {
                it.toCoin()
            }
            emit(ResponseState.Success<List<Coin>>(coins))
        } catch (e: HttpException) {
            emit(ResponseState.Error<List<Coin>>(e.localizedMessage ?: "HTTP Error"))
        } catch (e: IOException) {
            emit(ResponseState.Error<List<Coin>>("IO Error"))
        }
    }
}