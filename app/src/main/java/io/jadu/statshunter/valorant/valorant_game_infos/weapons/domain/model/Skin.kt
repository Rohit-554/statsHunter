package io.jadu.statshunter.valorant.valorant_game_infos.weapons.domain.model

data class Skin(
    val assetPath: String,
    val chromas: List<Chroma?>,
    val contentTierUuid: String,
    val displayIcon: String,
    val displayName: String,
    val levels: List<Level?>,
    val themeUuid: String,
    val uuid: String,
    val wallpaper: String
)