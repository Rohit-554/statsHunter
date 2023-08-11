package io.jadu.statshunter.valorant.valorant_game_infos.buddies.domain.model


data class Data(
    val assetPath: String,
    val displayIcon: String,
    val displayName: String,
    val isHiddenIfNotOwned: Boolean,
    val levelDtos: List<Level>,
    val themeUuid: String,
    val uuid: String
)
