package io.jadu.statshunter.valorant.data.data_source.remote

import io.jadu.statshunter.valorant.valorant_game_infos.competitiveTiers.data.data_source.remote.dto.CompetitiveTiersDto
import io.jadu.statshunter.valorant.valorant_game_infos.agents.data.data_source.remote.dto.AgentInfoDto
import io.jadu.statshunter.valorant.valorant_game_infos.buddies.data.data_source.remote.BuddiesInfoDto
import io.jadu.statshunter.valorant.valorant_game_infos.bundles.data.data_source.remote.dto.BundleInfoDto
import io.jadu.statshunter.valorant.valorant_game_infos.ceremonies.data.data_source.remote.dto.CeremoniesDto
import io.jadu.statshunter.valorant.valorant_game_infos.contracts.data.data_source.remote.dto.ContractsDto
import io.jadu.statshunter.valorant.valorant_game_infos.currencies.data.data_source.remote.dto.CurrenciesDto
import io.jadu.statshunter.valorant.valorant_game_infos.events.data.data_source.remote.dto.EventsDto
import io.jadu.statshunter.valorant.valorant_game_infos.game_modes.data.data_source.remote.dto.GameModesDto
import io.jadu.statshunter.valorant.valorant_game_infos.gears.data.data_source.remote.dto.GearsDto
import io.jadu.statshunter.valorant.valorant_game_infos.maps.data.data_source.remote.dto.MapsDto
import io.jadu.statshunter.valorant.valorant_game_infos.seasons.data.data_source.remote.dto.SeasonDto
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
    suspend fun getContractsDetails():ContractsDto

    @GET("currencies")
    suspend fun getCurrencies(): CurrenciesDto

    @GET("events")
    suspend fun getEvents(): EventsDto

    @GET("gamemodes")
    suspend fun getGameModes(): GameModesDto

    @GET("gear")
    suspend fun getGears(): GearsDto

    @GET("maps")
    suspend fun getMaps(): MapsDto

    @GET("seasons")
    suspend fun getSeasons(): SeasonDto



}