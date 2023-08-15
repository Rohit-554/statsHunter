package io.jadu.statshunter.valorant.valorant_game_infos.competitiveTiers.data.repository

import io.jadu.statshunter.valorant.data.data_source.remote.ValorantApiService
import io.jadu.statshunter.valorant.valorant_game_infos.competitiveTiers.data.data_source.remote.dto.CompetitiveTiersDto
import io.jadu.statshunter.valorant.valorant_game_infos.competitiveTiers.domain.repository.CompetitiveTiersRepository

class CompetitiveTiersRepositoryImpl(private val valorantApiService: ValorantApiService): CompetitiveTiersRepository {
    override suspend fun getCompetitiveTiers(): CompetitiveTiersDto {
        return valorantApiService.getCompetitiveTiersDetails()
    }
}