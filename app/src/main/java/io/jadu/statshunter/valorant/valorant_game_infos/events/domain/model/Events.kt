package io.jadu.statshunter.valorant.valorant_game_infos.events.domain.model

data class Events(
    val `data`: List<EventsData>,
    val status: Int
)