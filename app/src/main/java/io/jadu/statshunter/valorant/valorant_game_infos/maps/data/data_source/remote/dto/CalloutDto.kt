package io.jadu.statshunter.valorant.valorant_game_infos.maps.data.data_source.remote.dto

import io.jadu.statshunter.valorant.valorant_game_infos.maps.domain.models.Callout

data class CalloutDto(
    val location: LocationDto?,
    val regionName: String?,
    val superRegionName: String?
)

fun CalloutDto?.toDomainCallout(): Callout {
    return Callout(
        location = this?.location?.toDomainLocation() ?: LocationDto(0.0,0.0).toDomainLocation(),
        regionName = this?.regionName ?: "",
        superRegionName = this?.superRegionName ?: ""
    )
}