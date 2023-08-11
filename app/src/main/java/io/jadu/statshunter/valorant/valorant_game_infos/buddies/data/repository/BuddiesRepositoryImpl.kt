package io.jadu.statshunter.valorant.valorant_game_infos.buddies.data.repository

import io.jadu.statshunter.valorant.data.data_source.remote.ValorantApiService
import io.jadu.statshunter.valorant.valorant_game_infos.buddies.data.data_source.remote.BuddiesInfoDto
import io.jadu.statshunter.valorant.valorant_game_infos.buddies.domain.repository.BuddiesRepository

class BuddiesRepositoryImpl (private val agentsApi: ValorantApiService): BuddiesRepository {
    override suspend fun getBuddiesInfo(): BuddiesInfoDto {
        return agentsApi.getBuddiesDetails()
    }


}