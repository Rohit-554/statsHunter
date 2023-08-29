package io.jadu.statshunter.valorant.valorant_game_infos.maps.data.data_source.remote.dto

import io.jadu.statshunter.valorant.valorant_game_infos.maps.domain.models.Maps

data class MapsDto(
    val `data`: List<MapsDataDto>?,
    val status: Int?
)

fun MapsDto?.toDomainMaps(): Maps {
    return Maps(
        data = this?.data?.map { it.toDomainMapsData() } ?: listOf(),
        status = this?.status ?: 0
    )
}
