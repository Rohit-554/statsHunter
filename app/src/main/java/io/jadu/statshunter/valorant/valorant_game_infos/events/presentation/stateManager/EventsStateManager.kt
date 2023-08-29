package io.jadu.statshunter.valorant.valorant_game_infos.events.presentation.stateManager

import io.jadu.statshunter.valorant.valorant_game_infos.events.domain.model.Events


data class EventsStateManager (
    val eventsState: Events? = null,
    val isLoading: Boolean = false,
    val error: String? = null
)