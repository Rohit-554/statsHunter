package io.jadu.statshunter.valorant.valorant_game_infos.buddies.domain.repository

import io.jadu.statshunter.valorant.valorant_game_infos.buddies.data.data_source.remote.BuddiesInfoDto
import io.jadu.statshunter.valorant.valorant_game_infos.buddies.domain.model.BuddiesInfo

interface BuddiesRepository {
    suspend fun getBuddiesInfo():BuddiesInfoDto
}