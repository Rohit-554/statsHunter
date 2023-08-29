package io.jadu.statshunter.valorant.valorant_game_infos.contracts.data.data_source.remote.dto

import io.jadu.statshunter.valorant.valorant_game_infos.contracts.domain.model.Level


data class LevelDto(
    val doughCost: Int?,
    val isPurchasableWithDough: Boolean?,
    val isPurchasableWithVP: Boolean?,
    val reward: RewardDto?,
    val vpCost: Int?,
    val xp: Int?
)

fun LevelDto?.toDomainLevel(): Level {
    return Level(
        doughCost = this?.doughCost ?: 0,
        isPurchasableWithDough = this?.isPurchasableWithDough ?: false,
        isPurchasableWithVP = this?.isPurchasableWithVP ?: false,
        reward = this?.reward?.toDomainReward() ?: RewardDto(0,false,"","").toDomainReward(),
        vpCost = this?.vpCost ?: 0,
        xp = this?.xp ?: 0
    )
}