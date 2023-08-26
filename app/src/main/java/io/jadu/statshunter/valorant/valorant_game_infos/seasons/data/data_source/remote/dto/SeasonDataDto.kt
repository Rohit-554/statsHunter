package io.jadu.statshunter.valorant.valorant_game_infos.seasons.data.data_source.remote.dto

import io.jadu.statshunter.valorant.valorant_game_infos.seasons.domain.models.SeasonData

data class SeasonDataDto(
    val assetPath: String,
    val displayName: String,
    val endTime: String,
    val parentUuid: String,
    val startTime: String,
    val type: String,
    val uuid: String
)

fun SeasonDataDto?.toSeasonData(): SeasonData? {
    return this?.let {
        SeasonData(
            assetPath = it.assetPath,
            displayName = it.displayName,
            endTime = it.endTime,
            parentUuid = it.parentUuid,
            startTime = it.startTime,
            type = it.type,
            uuid = it.uuid
        )
    }
}