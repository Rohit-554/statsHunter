package io.jadu.statshunter.valorant.valorant_game_infos.game_modes.domain.repository

import io.jadu.statshunter.valorant.valorant_game_infos.game_modes.data.data_source.remote.dto.GameModesDto
import io.jadu.statshunter.valorant.valorant_game_infos.game_modes.domain.model.GameModes

interface GameModeRepository {
    suspend fun getGameModes(): GameModesDto
}