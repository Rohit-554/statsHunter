package io.jadu.statshunter.valorant.valorant_game_infos.weapons.domain.model

data class DamageRange(
    val bodyDamage: Int,
    val headDamage: Double,
    val legDamage: Double,
    val rangeEndMeters: Int,
    val rangeStartMeters: Int
)