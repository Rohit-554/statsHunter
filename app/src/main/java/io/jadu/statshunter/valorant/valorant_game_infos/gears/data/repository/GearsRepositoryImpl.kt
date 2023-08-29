package io.jadu.statshunter.valorant.valorant_game_infos.gears.data.repository

import io.jadu.statshunter.valorant.data.data_source.remote.ValorantApiService
import io.jadu.statshunter.valorant.valorant_game_infos.gears.data.data_source.remote.dto.GearsDto
import io.jadu.statshunter.valorant.valorant_game_infos.gears.domain.repository.GearsRepository

class GearsRepositoryImpl(private val valorantApiService: ValorantApiService): GearsRepository {
    override suspend fun getGears(): GearsDto {
        return valorantApiService.getGears()
    }

}