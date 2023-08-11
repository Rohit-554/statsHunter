package io.jadu.statshunter.valorant.valorant_game_infos.agents.data.data_source.remote.dto

import io.jadu.statshunter.valorant.valorant_game_infos.agents.domain.model.AgentInfo

data class AgentInfoDto(
    val `data`: List<DataDto>,
    val status: Int
)

fun AgentInfoDto.toDomainAgentInfo(): AgentInfo {
    return AgentInfo(
        data = data.map { it.toDomainAgentInfo() },
        status = status
    )
}