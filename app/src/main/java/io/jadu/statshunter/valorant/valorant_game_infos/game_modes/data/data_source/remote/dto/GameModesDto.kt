package io.jadu.statshunter.valorant.valorant_game_infos.game_modes.data.data_source.remote.dto

import io.jadu.statshunter.valorant.valorant_game_infos.game_modes.domain.model.GameModes

data class GameModesDto(
    val `data`: List<GameModeDataDto>?,
    val status: Int?
)

fun GameModesDto?.toDomainGameModes(): GameModes {
    return GameModes(
        data = this?.data?.map { it.toDomainGameModeData() } ?: emptyList(),
        status = this?.status ?: 0
    )
}