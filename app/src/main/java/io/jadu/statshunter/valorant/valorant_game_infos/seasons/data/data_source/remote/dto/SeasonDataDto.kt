package io.jadu.statshunter.valorant.valorant_game_infos.seasons.data.data_source.remote.dto

import io.jadu.statshunter.valorant.valorant_game_infos.seasons.domain.models.SeasonData

data class SeasonDataDto(
    val assetPath: String?,
    val displayName: String?,
    val endTime: String?,
    val parentUuid: String?,
    val startTime: String?,
    val type: String?,
    val uuid: String?
)

fun SeasonDataDto?.toDomainSeasonData(): SeasonData {
    return SeasonData(
        assetPath = this?.assetPath ?: "",
        displayName = this?.displayName ?: "",
        endTime = this?.endTime ?: "",
        parentUuid = this?.parentUuid ?: "",
        startTime = this?.startTime ?: "",
        type = this?.type ?: "",
        uuid = this?.uuid ?: ""
    )
}