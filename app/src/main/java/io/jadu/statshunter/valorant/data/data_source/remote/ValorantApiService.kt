package io.jadu.statshunter.valorant.data.data_source.remote

import io.jadu.statshunter.valorant.valorant_game_infos.agents.data.data_source.remote.dto.AgentInfoDto
import io.jadu.statshunter.valorant.valorant_game_infos.agents.domain.model.AgentInfo
import retrofit2.Response
import retrofit2.http.GET

interface ValorantApiService {

    @GET("agents")
    suspend fun getAgentDetails():AgentInfoDto

}