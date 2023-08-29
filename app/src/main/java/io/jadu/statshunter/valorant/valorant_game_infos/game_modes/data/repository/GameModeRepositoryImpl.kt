package io.jadu.statshunter.valorant.valorant_game_infos.game_modes.data.repository

import io.jadu.statshunter.valorant.data.data_source.remote.ValorantApiService
import io.jadu.statshunter.valorant.valorant_game_infos.game_modes.data.data_source.remote.dto.GameModesDto
import io.jadu.statshunter.valorant.valorant_game_infos.game_modes.domain.repository.GameModeRepository

class GameModeRepositoryImpl(private val valorantApiService: ValorantApiService): GameModeRepository {
    override suspend fun getGameModes(): GameModesDto {
        return valorantApiService.getGameModes()
    }
}