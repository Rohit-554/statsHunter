package io.jadu.statshunter.valorant.valorant_game_infos.events.data.data_source.remote.dto

data class EventsDataDto(
    val assetPath: String,
    val displayName: String,
    val endTime: String,
    val shortDisplayName: String,
    val startTime: String,
    val uuid: String
)

fun EventsDataDto.toDomainEventsData(): io.jadu.statshunter.valorant.valorant_game_infos.events.domain.model.EventsData {
    return io.jadu.statshunter.valorant.valorant_game_infos.events.domain.model.EventsData(
        assetPath = assetPath,
        displayName = displayName,
        endTime = endTime,
        shortDisplayName = shortDisplayName,
        startTime = startTime,
        uuid = uuid
    )
}