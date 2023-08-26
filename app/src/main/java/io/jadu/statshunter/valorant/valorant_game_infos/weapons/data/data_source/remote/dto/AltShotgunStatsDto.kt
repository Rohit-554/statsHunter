package io.jadu.statshunter.valorant.valorant_game_infos.weapons.data.data_source.remote.dto

import io.jadu.statshunter.valorant.valorant_game_infos.weapons.domain.model.AltShotgunStats

data class AltShotgunStatsDto(
    val burstRate: Double,
    val shotgunPelletCount: Int
)

fun AltShotgunStatsDto?.toDomainAltShotgunStats(): AltShotgunStats? {
    return this?.let {
        AltShotgunStats(
            burstRate = it.burstRate,
            shotgunPelletCount = it.shotgunPelletCount
        )
    }
}