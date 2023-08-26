package io.jadu.statshunter.valorant.valorant_game_infos.maps.domain.models

data class MapsData(
    val assetPath: String,
    val callouts: List<Callout>,
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