package io.jadu.statshunter.valorant.valorant_game_infos.buddies.domain.use_case

import android.util.Log
import io.jadu.statshunter.valorant.core.constants.Constants
import io.jadu.statshunter.valorant.core.utils.Resource
import io.jadu.statshunter.valorant.valorant_game_infos.agents.data.data_source.remote.dto.toDomainAgentInfo
import io.jadu.statshunter.valorant.valorant_game_infos.buddies.data.data_source.remote.toDomainBuddiesInfo
import io.jadu.statshunter.valorant.valorant_game_infos.buddies.domain.model.BuddiesInfo
import io.jadu.statshunter.valorant.valorant_game_infos.buddies.domain.repository.BuddiesRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException


class GetBuddiesDetailUseCase(private val buddiesRepository: BuddiesRepository) {

    operator fun invoke(): Flow<Resource<BuddiesInfo>> = flow {
        try {
            emit(Resource.Loading())
            val response = buddiesRepository.getBuddiesInfo().toDomainBuddiesInfo()
            emit(Resource.Success(response))
        } catch (e: HttpException) {

            Log.d("AgentsRepositoryImpl", "getAgentsInfo: error2")
            emit(
                Resource.Error(
                    data = null,
                    message = Constants.INTERNETDOWN,
                )
            )

        } catch (e: IOException) {

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

