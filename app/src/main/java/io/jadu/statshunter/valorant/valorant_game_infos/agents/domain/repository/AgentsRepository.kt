package io.jadu.statshunter.valorant.valorant_game_infos.agents.domain.repository

import io.jadu.statshunter.valorant.core.utils.Resource
import io.jadu.statshunter.valorant.valorant_game_infos.agents.data.data_source.remote.dto.AgentInfoDto
import io.jadu.statshunter.valorant.valorant_game_infos.agents.domain.model.AgentInfo
import kotlinx.coroutines.flow.Flow

interface AgentsRepository {

    suspend fun getAgentsInfo(): AgentInfoDto

}