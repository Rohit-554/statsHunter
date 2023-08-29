package io.jadu.statshunter.valorant.valorant_game_infos.maps.data.repository

import io.jadu.statshunter.valorant.data.data_source.remote.ValorantApiService
import io.jadu.statshunter.valorant.valorant_game_infos.maps.data.data_source.remote.dto.MapsDto
import io.jadu.statshunter.valorant.valorant_game_infos.maps.domain.repository.MapsRepository

class MapsRepositoryImpl(private val valorantApiService: ValorantApiService): MapsRepository {
    override suspend fun getMaps(): MapsDto {
        return valorantApiService.getMaps()
    }

}