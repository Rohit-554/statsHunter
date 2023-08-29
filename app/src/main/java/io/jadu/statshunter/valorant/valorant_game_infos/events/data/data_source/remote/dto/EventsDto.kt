package io.jadu.statshunter.valorant.valorant_game_infos.events.data.data_source.remote.dto

import io.jadu.statshunter.valorant.valorant_game_infos.events.domain.model.Events

data class EventsDto(
    val `data`: List<EventsDataDto>?,
    val status: Int?
)

fun EventsDto?.toDomainEvents(): Events {
    return Events(
        data = this?.data?.map { it.toDomainEventsData() } ?: emptyList(),
        status = this?.status ?: 0
    )
}


