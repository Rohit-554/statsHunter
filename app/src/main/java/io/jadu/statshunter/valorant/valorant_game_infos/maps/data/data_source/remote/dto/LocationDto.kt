package io.jadu.statshunter.valorant.valorant_game_infos.maps.data.data_source.remote.dto

import io.jadu.statshunter.valorant.valorant_game_infos.maps.domain.models.Location

data class LocationDto(
    val x: Double?,
    val y: Double?
)

fun LocationDto?.toDomainLocation(): Location{
    return Location(
        x = this?.x ?: 0.0,
        y = this?.y ?: 0.0
    )
}