package io.jadu.statshunter.valorant.valorant_game_infos.game_modes.data.data_source.remote.dto

import io.jadu.statshunter.valorant.valorant_game_infos.game_modes.domain.model.GameModes

data class GameModesDto(
    val `data`: List<GameModeDataDto>,
    val status: Int
)

fun GameModesDto?.toDomainEvents(): GameModes? {
    return this?.let {
        it.data.map { gameModeDataDto -> gameModeDataDto.toDomainGameModeData() }.let { it1 ->
            GameModes(
                data = it1,
                status = it.status
            )
        }
    }
}