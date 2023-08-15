package io.jadu.statshunter.valorant.data.data_source.remote

import io.jadu.statshunter.valorant.valorant_game_infos.competitiveTiers.data.data_source.remote.dto.CompetitiveTiersDto
import io.jadu.statshunter.valorant.valorant_game_infos.agents.data.data_source.remote.dto.AgentInfoDto
import io.jadu.statshunter.valorant.valorant_game_infos.buddies.data.data_source.remote.BuddiesInfoDto
import io.jadu.statshunter.valorant.valorant_game_infos.bundles.data.data_source.remote.dto.BundleInfoDto
import io.jadu.statshunter.valorant.valorant_game_infos.ceremonies.data.data_source.remote.dto.CeremoniesDto
import retrofit2.http.GET

interface ValorantApiService {

    @GET("agents")
    suspend fun getAgentDetails():AgentInfoDto

    @GET("buddies")
    suspend fun getBuddiesDetails():BuddiesInfoDto

    @GET("bundles")
    suspend fun getBundlesDetails():BundleInfoDto

    @GET("ceremonies")
    suspend fun getCeremoniesDetails(): CeremoniesDto

    @GET("competitivetiers")
    suspend fun getCompetitiveTiersDetails(): CompetitiveTiersDto

    @GET("contracts")
    suspend fun getContractsDetails()






}