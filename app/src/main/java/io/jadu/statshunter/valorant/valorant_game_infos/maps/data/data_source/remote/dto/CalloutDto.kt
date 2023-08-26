package io.jadu.statshunter.valorant.valorant_game_infos.maps.data.data_source.remote.dto

import io.jadu.statshunter.valorant.valorant_game_infos.maps.domain.models.Callout

data class CalloutDto(
    val location: LocationDto,
    val regionName: String,
    val superRegionName: String
)

fun CalloutDto?.toDomainCallout(): Callout? {
    return this?.let {
        it.location.toDomainLocation()?.let { it1 ->
            Callout(
                location = it1,
                regionName = it.regionName,
                superRegionName = it.superRegionName
            )
        }
    }
}