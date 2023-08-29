package io.jadu.statshunter.valorant.valorant_game_infos.events.data.repository

import io.jadu.statshunter.valorant.data.data_source.remote.ValorantApiService
import io.jadu.statshunter.valorant.valorant_game_infos.events.data.data_source.remote.dto.EventsDto
import io.jadu.statshunter.valorant.valorant_game_infos.events.domain.repository.EventsRepository

class EventsRepositoryImpl(private val valorantApiService: ValorantApiService): EventsRepository {
    override suspend fun getEvents(): EventsDto {
        return valorantApiService.getEvents()
    }

}