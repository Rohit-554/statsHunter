package io.jadu.statshunter.valorant.valorant_game_infos.maps.data.data_source.remote.dto

import io.jadu.statshunter.valorant.valorant_game_infos.maps.domain.models.MapsData

data class MapsDataDto(
    val assetPath: String,
    val callouts: List<CalloutDto>,
    val coordinates: String,
    val displayIcon: String,
    val displayName: String,
    val listViewIcon: String,
    val mapUrl: String,
    val narrativeDescription: String,
    val splash: String,
    val tacticalDescription: String,
    val uuid: String,
    val xMultiplier: Double,
    val xScalarToAdd: Double,
    val yMultiplier: Double,
    val yScalarToAdd: Double
)

fun MapsDataDto?.toDomainMapsData(): MapsData? {
    return this?.let {
        MapsData(
            assetPath = it.assetPath,
            callouts = it.callouts.mapNotNull { calloutDto -> calloutDto.toDomainCallout() },
            coordinates = it.coordinates,
            displayIcon = it.displayIcon,
            displayName = it.displayName,
            listViewIcon = it.listViewIcon,
            mapUrl = it.mapUrl,
            narrativeDescription = it.narrativeDescription,
            splash = it.splash,
            tacticalDescription = it.tacticalDescription,
            uuid = it.uuid,
            xMultiplier = it.xMultiplier,
            xScalarToAdd = it.xScalarToAdd,
            yMultiplier = it.yMultiplier,
            yScalarToAdd = it.yScalarToAdd
        )
    }
}