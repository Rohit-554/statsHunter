package io.jadu.statshunter.valorant.valorant_game_infos.agents.data.repository

import io.jadu.statshunter.valorant.core.utils.Resource
import io.jadu.statshunter.valorant.data.data_source.remote.ValorantApiService
import io.jadu.statshunter.valorant.valorant_game_infos.agents.domain.model.AgentInfo
import io.jadu.statshunter.valorant.valorant_game_infos.agents.domain.repository.AgentsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException


class AgentsRepositoryImpl(private val agentsApi: ValorantApiService) : AgentsRepository {
    private val InternetDown = "\"Agent, it seems we're experiencing a bit of interference in the digital realm. Our agents are working on restoring the connection to the Valorant universe." +
            "        Until then, consider mastering your aim offline," +
            "        just like Jett in her downtime. Remember, tactical prowess knows no boundaries – not even the digital ones." +
            "        Stay patient and sharp, and we'll have you back in the action as soon as possible.\""


    override fun getAgentsInfo(): Flow<Resource<AgentInfo>> = flow {
        emit(Resource.Loading())
        try {
            val response = agentsApi.getAgentDetails()
            response.body()?.let { emit(Resource.Success(it)) }
        } catch (e: IOException) {
            emit(
                Resource.Error(
                    data = null,
                    message = InternetDown,
                )
            )
        } catch (e: HttpException) {
            emit(
                Resource.Error(
                    data = null,
                    message = "Looks like Phoenix burned the wires! We're working on it...",
                )
            )
        }
    }


}