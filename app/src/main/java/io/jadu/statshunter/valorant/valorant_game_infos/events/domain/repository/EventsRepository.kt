package io.jadu.statshunter.valorant.valorant_game_infos.events.domain.repository

import io.jadu.statshunter.valorant.valorant_game_infos.events.data.data_source.remote.dto.EventsDto
import io.jadu.statshunter.valorant.valorant_game_infos.events.domain.model.Events

interface EventsRepository {
    suspend fun getEvents():EventsDto
}