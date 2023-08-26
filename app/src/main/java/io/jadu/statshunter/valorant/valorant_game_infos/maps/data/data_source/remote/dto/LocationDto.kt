package io.jadu.statshunter.valorant.valorant_game_infos.maps.data.data_source.remote.dto

import io.jadu.statshunter.valorant.valorant_game_infos.maps.domain.models.Location

data class LocationDto(
    val x: Double,
    val y: Double
)

fun LocationDto?.toDomainLocation(): Location? {
    return this?.let {
        Location(
            x = it.x,
            y = it.y
        )
    }
}