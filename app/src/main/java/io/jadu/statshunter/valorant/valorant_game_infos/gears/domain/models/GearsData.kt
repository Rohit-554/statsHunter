package io.jadu.statshunter.valorant.valorant_game_infos.gears.domain.models

data class GearsData(
    val assetPath: String,
    val description: String,
    val displayIcon: String,
    val displayName: String,
    val shopData: ShopData,
    val uuid: String
)