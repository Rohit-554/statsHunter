package io.jadu.statshunter.valorant.valorant_game_infos.agents.data.repository

import android.util.Log
import io.jadu.statshunter.valorant.core.utils.Resource
import io.jadu.statshunter.valorant.data.data_source.remote.ValorantApiService
import io.jadu.statshunter.valorant.valorant_game_infos.agents.data.data_source.remote.dto.AgentInfoDto
import io.jadu.statshunter.valorant.valorant_game_infos.agents.domain.model.AgentInfo
import io.jadu.statshunter.valorant.valorant_game_infos.agents.domain.repository.AgentsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException


class AgentsRepositoryImpl(private val agentsApi: ValorantApiService) : AgentsRepository {

        override suspend fun getAgentsInfo(): AgentInfoDto {
            return agentsApi.getAgentDetails()
        }


}