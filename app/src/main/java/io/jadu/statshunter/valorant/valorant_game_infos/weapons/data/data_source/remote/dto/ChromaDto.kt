package io.jadu.statshunter.valorant.valorant_game_infos.weapons.data.data_source.remote.dto

import io.jadu.statshunter.valorant.valorant_game_infos.weapons.domain.model.Chroma

data class ChromaDto(
    val assetPath: String,
    val displayIcon: String,
    val displayName: String,
    val fullRender: String,
    val streamedVideo: String,
    val swatch: String,
    val uuid: String
)

fun ChromaDto?.toDomainChroma(): Chroma? {
    return this?.let {
        Chroma(
            assetPath = it.assetPath,
            displayIcon = it.displayIcon,
            displayName = it.displayName,
            fullRender = it.fullRender,
            streamedVideo = it.streamedVideo,
            swatch = it.swatch,
            uuid = it.uuid
        )
    }
}