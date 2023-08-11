package io.jadu.statshunter.valorant.valorant_game_infos.agents.data.data_source.remote.dto

import io.jadu.statshunter.valorant.valorant_game_infos.agents.domain.model.VoiceLine

data class VoiceLineDto(
    val maxDuration: Double?,
    val mediaList: List<MediaDto>?,
    val minDuration: Double?
)
fun VoiceLineDto?.toDomainVoiceLine(): VoiceLine {
    return VoiceLine(
        maxDuration = this?.maxDuration ?: 0.0,
        mediaList = this?.mediaList?.map { it.toDomainMedia() } ?: listOf(),
        minDuration = this?.minDuration ?: 0.0
    )
}