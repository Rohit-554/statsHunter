package io.jadu.statshunter.valorant.valorant_game_infos.agents.domain.use_case

import io.jadu.statshunter.valorant.core.utils.Resource
import io.jadu.statshunter.valorant.valorant_game_infos.agents.domain.model.AgentInfo
import io.jadu.statshunter.valorant.valorant_game_infos.agents.domain.repository.AgentsRepository

class GetAgentDetail(
    private val repository: AgentsRepository
) {
    operator fun invoke(): kotlinx.coroutines.flow.Flow<Resource<AgentInfo>> {
        return repository.getAgentsInfo()
    }
}