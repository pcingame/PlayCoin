package com.example.playcoin.domain.use_case

import com.example.playcoin.common.utils.ResponseState
import com.example.playcoin.domain.model.CoinDetail
import com.example.playcoin.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class CoinDetailUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    operator fun invoke(id: String): Flow<ResponseState<CoinDetail>> = flow {
        try {
            emit(ResponseState.Loading<CoinDetail>())
            val coinDetail = repository.getCoinById(id).toCoinDetail()
            emit(ResponseState.Success<CoinDetail>(coinDetail))
        } catch (e: HttpException) {
            emit(ResponseState.Error<CoinDetail>(e.localizedMessage ?: "HTTP Error"))
        } catch (e: IOException) {
            emit(ResponseState.Error<CoinDetail>("IO Error"))
        }
    }
}