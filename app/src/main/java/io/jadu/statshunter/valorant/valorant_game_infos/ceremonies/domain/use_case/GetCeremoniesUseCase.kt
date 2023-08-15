package io.jadu.statshunter.valorant.valorant_game_infos.ceremonies.domain.use_case

import android.util.Log
import io.jadu.statshunter.valorant.core.constants.Constants
import io.jadu.statshunter.valorant.core.utils.Resource
import io.jadu.statshunter.valorant.valorant_game_infos.ceremonies.data.data_source.remote.dto.toCeremonies
import io.jadu.statshunter.valorant.valorant_game_infos.ceremonies.domain.model.Ceremonies
import io.jadu.statshunter.valorant.valorant_game_infos.ceremonies.domain.repository.CeremoniesRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException

class GetCeremoniesUseCase(private val ceremoniesRepository: CeremoniesRepository) {
    operator fun invoke(): Flow<Resource<Ceremonies>> = flow {
        try {
            emit(Resource.Loading())
            val response = ceremoniesRepository.getCeremoniesInfo().toCeremonies()
            emit(Resource.Success(response))
        }catch (e: HttpException){
            Log.d("AgentsRepositoryImpl", "getAgentsInfo: error2")
            emit(
                Resource.Error(
                    data = null,
                    message = Constants.INTERNETDOWN,
                )
            )
        }catch (e: IOException){
            Log.d("AgentsRepositoryImpl", "getAgentsInfo: error3")
            emit(
                Resource.Error(
                    data = null,
                    message = "Looks like Phoenix burned the wires! We're working on it...",
                )
            )
        }
    }
}