package io.jadu.statshunter.valorant.valorant_game_infos.weapons.data.data_source.remote.dto

import io.jadu.statshunter.valorant.valorant_game_infos.weapons.domain.model.AdsStats


data class AdsStatsDto(
    val burstCount: Int?,
    val fireRate: Double?,
    val firstBulletAccuracy: Double?,
    val runSpeedMultiplier: Double?,
    val zoomMultiplier: Double?
)

fun AdsStatsDto?.toDomainAdsStats(): AdsStats {
    return AdsStats(
        burstCount = this?.burstCount ?: 0,
        fireRate = this?.fireRate ?: 0.0,
        firstBulletAccuracy = this?.firstBulletAccuracy ?: 0.0,
        runSpeedMultiplier = this?.runSpeedMultiplier ?: 0.0,
        zoomMultiplier = this?.zoomMultiplier ?: 0.0
    )
}