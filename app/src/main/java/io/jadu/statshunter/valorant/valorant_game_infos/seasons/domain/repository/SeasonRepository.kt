package io.jadu.statshunter.valorant.valorant_game_infos.seasons.domain.repository

import io.jadu.statshunter.valorant.valorant_game_infos.seasons.data.data_source.remote.dto.SeasonDto

interface SeasonRepository {
    suspend fun getSeasons(): SeasonDto
}