package io.jadu.statshunter.valorant.valorant_game_infos.weapons.domain.model

data class AdsStats(
    val burstCount: Int,
    val fireRate: Double,
    val firstBulletAccuracy: Double,
    val runSpeedMultiplier: Double,
    val zoomMultiplier: Double
)