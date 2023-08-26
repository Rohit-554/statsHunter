package io.jadu.statshunter.valorant.valorant_game_infos.seasons.domain.models

data class SeasonData(
    val assetPath: String,
    val displayName: String,
    val endTime: String,
    val parentUuid: String,
    val startTime: String,
    val type: String,
    val uuid: String
)

