package io.jadu.statshunter.valorant.valorant_game_infos.weapons.data.data_source.remote.dto

import io.jadu.statshunter.valorant.valorant_game_infos.weapons.domain.model.DamageRange

data class DamageRangeDto(
    val bodyDamage: Int?,
    val headDamage: Double?,
    val legDamage: Double?,
    val rangeEndMeters: Int?,
    val rangeStartMeters: Int?
)

fun DamageRangeDto?.toDomainDamageRange(): DamageRange {
    return DamageRange(
        bodyDamage = this?.bodyDamage ?: 0,
        headDamage = this?.headDamage ?: 0.0,
        legDamage = this?.legDamage ?: 0.0,
        rangeEndMeters = this?.rangeEndMeters ?: 0,
        rangeStartMeters = this?.rangeStartMeters ?: 0
    )
}