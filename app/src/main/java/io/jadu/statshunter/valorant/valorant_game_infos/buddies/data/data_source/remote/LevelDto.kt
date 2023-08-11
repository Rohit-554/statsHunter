package io.jadu.statshunter.valorant.valorant_game_infos.buddies.data.data_source.remote

import io.jadu.statshunter.valorant.valorant_game_infos.buddies.domain.model.Level

data class LevelDto(
    val assetPath: String?,
    val charmLevel: Int?,
    val displayIcon: String?,
    val displayName: String?,
    val uuid: String?
)
fun LevelDto?.toDomainLevel(): Level {
    return Level(
        assetPath = this?.assetPath ?: "",
        charmLevel = this?.charmLevel ?: 0,
        displayIcon = this?.displayIcon ?: "",
        displayName = this?.displayName ?: "",
        uuid = this?.uuid ?: ""
    )
}


