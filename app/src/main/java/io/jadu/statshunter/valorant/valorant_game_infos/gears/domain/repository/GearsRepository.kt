package io.jadu.statshunter.valorant.valorant_game_infos.gears.domain.repository

import io.jadu.statshunter.valorant.valorant_game_infos.gears.data.data_source.remote.dto.GearsDto

interface GearsRepository {
    suspend fun getGears(): GearsDto
}