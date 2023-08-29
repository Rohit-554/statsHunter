package io.jadu.statshunter.valorant.valorant_game_infos.maps.data.data_source.remote.dto

import io.jadu.statshunter.valorant.valorant_game_infos.maps.domain.models.MapsData

data class MapsDataDto(
    val assetPath: String?,
    val callouts: List<CalloutDto>?,
    val coordinates: String?,
    val displayIcon: String?,
    val displayName: String?,
    val listViewIcon: String?,
    val mapUrl: String?,
    val narrativeDescription: String?,
    val splash: String?,
    val tacticalDescription: String?,
    val uuid: String?,
    val xMultiplier: Double?,
    val xScalarToAdd: Double?,
    val yMultiplier: Double?,
    val yScalarToAdd: Double?
)

fun MapsDataDto?.toDomainMapsData(): MapsData {
    return MapsData(
        assetPath = this?.assetPath ?: "",
        callouts = this?.callouts?.map { it.toDomainCallout() } ?: emptyList(),
        coordinates = this?.coordinates ?: "",
        displayIcon = this?.displayIcon ?: "",
        displayName = this?.displayName ?: "",
        listViewIcon = this?.listViewIcon ?: "",
        mapUrl = this?.mapUrl ?: "",
        narrativeDescription = this?.narrativeDescription ?: "",
        splash = this?.splash ?: "",
        tacticalDescription = this?.tacticalDescription ?: "",
        uuid = this?.uuid ?: "",
        xMultiplier = this?.xMultiplier ?: 0.0,
        xScalarToAdd = this?.xScalarToAdd ?: 0.0,
        yMultiplier = this?.yMultiplier ?: 0.0,
        yScalarToAdd = this?.yScalarToAdd ?: 0.0
    )
}