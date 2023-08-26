package io.jadu.statshunter.valorant.valorant_game_infos.weapons.data.data_source.remote.dto

import io.jadu.statshunter.valorant.valorant_game_infos.weapons.domain.model.AdsStats


data class AdsStatsDto(
    val burstCount: Int,
    val fireRate: Double,
    val firstBulletAccuracy: Double,
    val runSpeedMultiplier: Double,
    val zoomMultiplier: Double
)

fun AdsStatsDto?.toDomainAdsStats(): AdsStats? {
    return this?.let {
        AdsStats(
            burstCount = it.burstCount,
            fireRate = it.fireRate,
            firstBulletAccuracy = it.firstBulletAccuracy,
            runSpeedMultiplier = it.runSpeedMultiplier,
            zoomMultiplier = it.zoomMultiplier
        )
    }
}