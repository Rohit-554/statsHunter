package io.jadu.statshunter.valorant.valorant_game_infos.weapons.data.data_source.remote.dto

import io.jadu.statshunter.valorant.valorant_game_infos.weapons.domain.model.WeaponStats

data class WeaponStatsDto(
    val adsStats: AdsStatsDto,
    val airBurstStats: AirBurstStatsDto,
    val altFireType: String,
    val altShotgunStats: AltShotgunStatsDto,
    val damageRanges: List<DamageRangeDto>,
    val equipTimeSeconds: Double,
    val feature: String,
    val fireMode: String,
    val fireRate: Double,
    val firstBulletAccuracy: Double,
    val magazineSize: Int,
    val reloadTimeSeconds: Double,
    val runSpeedMultiplier: Double,
    val shotgunPelletCount: Int,
    val wallPenetration: String
)

fun WeaponStatsDto?.toDomainWeaponStats(): WeaponStats? {
    return this?.let {
        it.adsStats.toDomainAdsStats()?.let { it1 ->
            it.airBurstStats.toDomainAirBurstStats()?.let { it2 ->
                it.altShotgunStats.toDomainAltShotgunStats()?.let { it3 ->
                    WeaponStats(
                        adsStats = it1,
                        airBurstStats = it2,
                        altFireType = it.altFireType,
                        altShotgunStats = it3,
                        damageRanges = it.damageRanges.map { damageRange -> damageRange.toDomainDamageRange() },
                        equipTimeSeconds = it.equipTimeSeconds,
                        feature = it.feature,
                        fireMode = it.fireMode,
                        fireRate = it.fireRate,
                        firstBulletAccuracy = it.firstBulletAccuracy,
                        magazineSize = it.magazineSize,
                        reloadTimeSeconds = it.reloadTimeSeconds,
                        runSpeedMultiplier = it.runSpeedMultiplier,
                        shotgunPelletCount = it.shotgunPelletCount,
                        wallPenetration = it.wallPenetration
                    )
                }
            }
        }
    }
}