package io.jadu.statshunter.valorant.valorant_game_infos.weapons.data.data_source.remote.dto

import io.jadu.statshunter.valorant.valorant_game_infos.weapons.domain.model.GridPosition

data class GridPositionDto(
    val column: Int?,
    val row: Int?
)

fun GridPositionDto?.toDomainGridPosition(): GridPosition {
    return GridPosition(
        column = this?.column ?: 0,
        row = this?.row ?: 0
    )
}