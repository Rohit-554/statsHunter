package io.jadu.statshunter.valorant.data.data_source.remote

import io.jadu.statshunter.valorant.valorant_game_infos.agents.data.data_source.remote.dto.AgentInfoDto
import io.jadu.statshunter.valorant.valorant_game_infos.buddies.data.data_source.remote.BuddiesInfoDto
import retrofit2.http.GET

interface ValorantApiService {

    @GET("agents")
    suspend fun getAgentDetails():AgentInfoDto

    @GET("buddies")
    suspend fun getBuddiesDetails():BuddiesInfoDto

}