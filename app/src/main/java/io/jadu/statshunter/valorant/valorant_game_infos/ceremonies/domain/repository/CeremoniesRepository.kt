package io.jadu.statshunter.valorant.valorant_game_infos.ceremonies.domain.repository

import io.jadu.statshunter.valorant.valorant_game_infos.ceremonies.data.data_source.remote.dto.CeremoniesDto

interface CeremoniesRepository {
    suspend fun getCeremoniesInfo():CeremoniesDto
}