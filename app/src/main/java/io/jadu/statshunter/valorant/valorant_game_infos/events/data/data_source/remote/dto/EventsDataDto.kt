package io.jadu.statshunter.valorant.valorant_game_infos.events.data.data_source.remote.dto

import io.jadu.statshunter.valorant.valorant_game_infos.events.domain.model.EventsData

data class EventsDataDto(
    val assetPath: String?,
    val displayName: String?,
    val endTime: String?,
    val shortDisplayName: String?,
    val startTime: String?,
    val uuid: String?
)

fun EventsDataDto?.toDomainEventsData(): EventsData {
    return EventsData(
        assetPath = this?.assetPath ?: "",
        displayName = this?.displayName ?: "",
        endTime = this?.endTime ?: "",
        shortDisplayName = this?.shortDisplayName ?: "",
        startTime = this?.startTime ?: "",
        uuid = this?.uuid ?: ""
    )
}

