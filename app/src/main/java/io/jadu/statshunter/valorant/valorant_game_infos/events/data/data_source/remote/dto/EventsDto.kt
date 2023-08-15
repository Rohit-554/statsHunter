package io.jadu.statshunter.valorant.valorant_game_infos.events.data.data_source.remote.dto

data class EventsDto(
    val `data`: List<EventsDataDto>,
    val status: Int
)

fun EventsDto?.toDomainEvents(): io.jadu.statshunter.valorant.valorant_game_infos.events.domain.model.Events? {
    return this?.let {
        it.data.map { eventsDataDto -> eventsDataDto.toDomainEventsData() }.let { it1 ->
            io.jadu.statshunter.valorant.valorant_game_infos.events.domain.model.Events(
                data = it1,
                status = it.status
            )
        }
    }
}
