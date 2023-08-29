package io.jadu.statshunter.valorant.valorant_game_infos.currencies.domain.use_case

import android.util.Log
import io.jadu.statshunter.valorant.core.constants.Constants
import io.jadu.statshunter.valorant.core.utils.Resource
import io.jadu.statshunter.valorant.valorant_game_infos.currencies.data.data_source.remote.dto.toDomainCurrencies
import io.jadu.statshunter.valorant.valorant_game_infos.currencies.domain.model.Currencies
import io.jadu.statshunter.valorant.valorant_game_infos.currencies.domain.repository.CurrenciesRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException

class CurrenciesUseCase(private val currenciesRepository: CurrenciesRepository) {

    operator fun invoke(): Flow<Resource<Currencies>> = flow {
        try {
            emit(Resource.Loading())
            val response = currenciesRepository.getCurrencies().toDomainCurrencies()
            emit(Resource.Success(response))
        } catch (e: HttpException){
            emit(
                Resource.Error(
                    data = null,
                    message = Constants.INTERNETDOWN,
                )
            )
        }catch (e: IOException){
            emit(
                Resource.Error(
                    data = null,
                    message = "Looks like Phoenix burned the wires! We're working on it...",
                )
            )
        }
    }
}