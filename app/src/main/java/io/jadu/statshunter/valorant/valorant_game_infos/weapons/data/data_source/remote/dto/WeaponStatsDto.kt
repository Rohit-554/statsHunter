package io.jadu.statshunter.valorant.valorant_game_infos.weapons.data.data_source.remote.dto

import io.jadu.statshunter.valorant.valorant_game_infos.weapons.domain.model.WeaponStats

data class WeaponStatsDto(
    val adsStats: AdsStatsDto?,
    val airBurstStats: AirBurstStatsDto?,
    val altFireType: String?,
    val altShotgunStats: AltShotgunStatsDto?,
    val damageRanges: List<DamageRangeDto>?,
    val equipTimeSeconds: Double?,
    val feature: String?,
    val fireMode: String?,
    val fireRate: Double?,
    val firstBulletAccuracy: Double?,
    val magazineSize: Int?,
    val reloadTimeSeconds: Double?,
    val runSpeedMultiplier: Double?,
    val shotgunPelletCount: Int?,
    val wallPenetration: String?
)

fun WeaponStatsDto?.toDomainWeaponStats(): WeaponStats {
    return WeaponStats(
        adsStats = this?.adsStats?.toDomainAdsStats() ?: AdsStatsDto(0,0.0,0.0,0.0,0.0).toDomainAdsStats(),
        airBurstStats = this?.airBurstStats?.toDomainAirBurstStats() ?: AirBurstStatsDto(0.0,0).toDomainAirBurstStats(),
        altFireType = this?.altFireType ?: "",
        altShotgunStats = this?.altShotgunStats?.toDomainAltShotgunStats() ?: AltShotgunStatsDto(0.0,0).toDomainAltShotgunStats(),
        damageRanges = this?.damageRanges?.map { it.toDomainDamageRange() } ?: listOf(),
        equipTimeSeconds = this?.equipTimeSeconds ?: 0.0,
        feature = this?.feature ?: "",
        fireMode = this?.fireMode ?: "",
        fireRate = this?.fireRate ?: 0.0,
        firstBulletAccuracy = this?.firstBulletAccuracy ?: 0.0,
        magazineSize = this?.magazineSize ?: 0,
        reloadTimeSeconds = this?.reloadTimeSeconds ?: 0.0,
        runSpeedMultiplier = this?.runSpeedMultiplier ?: 0.0,
        shotgunPelletCount = this?.shotgunPelletCount ?: 0,
        wallPenetration = this?.wallPenetration ?: ""
    )
}



