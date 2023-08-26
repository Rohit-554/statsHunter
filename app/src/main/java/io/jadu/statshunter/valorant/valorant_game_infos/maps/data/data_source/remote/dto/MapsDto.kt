package io.jadu.statshunter.valorant.valorant_game_infos.maps.data.data_source.remote.dto

import io.jadu.statshunter.valorant.valorant_game_infos.maps.domain.models.Maps

data class MapsDto(
    val `data`: List<MapsDataDto>,
    val status: Int
)

fun MapsDto?.toDomainMaps():Maps? {
    return this?.let {
        Maps(
            data = it.`data`.mapNotNull { data -> data.toDomainMapsData() },
            status = it.status
        )
    }
}