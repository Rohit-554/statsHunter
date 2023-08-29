package io.jadu.statshunter.valorant.valorant_game_infos.seasons.data.repository

import io.jadu.statshunter.valorant.data.data_source.remote.ValorantApiService
import io.jadu.statshunter.valorant.valorant_game_infos.seasons.data.data_source.remote.dto.SeasonDto
import io.jadu.statshunter.valorant.valorant_game_infos.seasons.domain.repository.SeasonRepository

class SeasonRepositoryImpl(private val valorantApiService: ValorantApiService): SeasonRepository {
    override suspend fun getSeasons(): SeasonDto {
        return valorantApiService.getSeasons()
    }

}
