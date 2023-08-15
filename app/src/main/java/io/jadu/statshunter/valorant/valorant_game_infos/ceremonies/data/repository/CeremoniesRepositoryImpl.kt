package io.jadu.statshunter.valorant.valorant_game_infos.ceremonies.data.repository

import io.jadu.statshunter.valorant.data.data_source.remote.ValorantApiService
import io.jadu.statshunter.valorant.valorant_game_infos.ceremonies.data.data_source.remote.dto.CeremoniesDto
import io.jadu.statshunter.valorant.valorant_game_infos.ceremonies.domain.repository.CeremoniesRepository

class CeremoniesRepositoryImpl(private val valorantApiService: ValorantApiService): CeremoniesRepository {
    override suspend fun getCeremoniesInfo(): CeremoniesDto {
        return valorantApiService.getCeremoniesDetails()
    }


}