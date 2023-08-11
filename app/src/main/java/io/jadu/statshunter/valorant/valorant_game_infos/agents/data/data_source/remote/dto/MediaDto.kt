package io.jadu.statshunter.valorant.valorant_game_infos.agents.data.data_source.remote.dto

import io.jadu.statshunter.valorant.valorant_game_infos.agents.domain.model.Media

data class MediaDto(
    val id: Int?,
    val wave: String?,
    val wwise: String?
)

fun MediaDto?.toDomainMedia(): Media {
    return Media(
        id = this?.id ?: 0,
        wave = this?.wave ?: "",
        wwise = this?.wwise ?: ""
    )
}