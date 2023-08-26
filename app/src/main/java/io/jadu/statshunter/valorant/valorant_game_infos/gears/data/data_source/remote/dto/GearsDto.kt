package io.jadu.statshunter.valorant.valorant_game_infos.gears.data.data_source.remote.dto

import io.jadu.statshunter.valorant.valorant_game_infos.gears.domain.models.Gears

data class GearsDto(
    val `data`: List<GearsDataDto>,
    val status: Int
)

fun GearsDto?.toDomainGears(): Gears? {
    return this?.let {
        Gears(
            data = it.`data`.mapNotNull { data -> data.toDomainGearsData() },
            status = it.status
        )
    }
}
