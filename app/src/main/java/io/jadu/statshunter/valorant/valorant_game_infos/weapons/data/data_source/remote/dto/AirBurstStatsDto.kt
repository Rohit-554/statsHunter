package io.jadu.statshunter.valorant.valorant_game_infos.weapons.data.data_source.remote.dto

import io.jadu.statshunter.valorant.valorant_game_infos.weapons.domain.model.AirBurstStats

data class AirBurstStatsDto(
    val burstDistance: Double?,
    val shotgunPelletCount: Int?
)

fun AirBurstStatsDto?.toDomainAirBurstStats(): AirBurstStats {
    return AirBurstStats(
        burstDistance = this?.burstDistance ?: 0.0,
        shotgunPelletCount = this?.shotgunPelletCount ?: 0
    )
}