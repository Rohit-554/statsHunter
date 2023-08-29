package io.jadu.statshunter.valorant.valorant_game_infos.maps.domain.repository

import io.jadu.statshunter.valorant.valorant_game_infos.maps.data.data_source.remote.dto.MapsDto

interface MapsRepository {
    suspend fun getMaps(): MapsDto
}