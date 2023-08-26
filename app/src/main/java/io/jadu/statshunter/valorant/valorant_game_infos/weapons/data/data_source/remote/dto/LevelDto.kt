package io.jadu.statshunter.valorant.valorant_game_infos.weapons.data.data_source.remote.dto

import io.jadu.statshunter.valorant.valorant_game_infos.weapons.domain.model.Level


data class LevelDto(
    val assetPath: String,
    val displayIcon: String,
    val displayName: String,
    val levelItem: String,
    val streamedVideo: String,
    val uuid: String
)

fun LevelDto?.toDomainLevel(): Level? {
    return this?.let {
        Level(
            assetPath = it.assetPath,
            displayIcon = it.displayIcon,
            displayName = it.displayName,
            levelItem = it.levelItem,
            streamedVideo = it.streamedVideo,
            uuid = it.uuid
        )
    }
}