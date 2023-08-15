package io.jadu.statshunter.valorant.valorant_game_infos.competitiveTiers.domain.repository

import io.jadu.statshunter.valorant.valorant_game_infos.competitiveTiers.data.data_source.remote.dto.CompetitiveTiersDto

interface CompetitiveTiersRepository {
    suspend fun getCompetitiveTiers():CompetitiveTiersDto
}