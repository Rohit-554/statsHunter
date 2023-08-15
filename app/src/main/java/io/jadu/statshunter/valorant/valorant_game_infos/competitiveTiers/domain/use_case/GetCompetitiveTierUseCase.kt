package io.jadu.statshunter.valorant.valorant_game_infos.competitiveTiers.domain.use_case

import android.util.Log
import io.jadu.statshunter.valorant.core.constants.Constants
import io.jadu.statshunter.valorant.core.utils.Resource
import io.jadu.statshunter.valorant.valorant_game_infos.competitiveTiers.data.data_source.remote.dto.toDomainCompetitiveTiers
import io.jadu.statshunter.valorant.valorant_game_infos.competitiveTiers.domain.model.CompetitiveTiers
import io.jadu.statshunter.valorant.valorant_game_infos.competitiveTiers.domain.repository.CompetitiveTiersRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException

class GetCompetitiveTierUseCase(private val repository: CompetitiveTiersRepository) {

    operator fun invoke():Flow<Resource<CompetitiveTiers>> = flow {
        try {
            emit(Resource.Loading())
            val response = repository.getCompetitiveTiers().toDomainCompetitiveTiers()
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