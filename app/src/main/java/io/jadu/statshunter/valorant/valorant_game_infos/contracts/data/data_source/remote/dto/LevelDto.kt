package io.jadu.statshunter.valorant.valorant_game_infos.contracts.data.data_source.remote.dto

import io.jadu.statshunter.valorant.valorant_game_infos.buddies.domain.model.Level

data class LevelDto(
    val doughCost: Int,
    val isPurchasableWithDough: Boolean,
    val isPurchasableWithVP: Boolean,
    val reward: RewardDto,
    val vpCost: Int,
    val xp: Int
)

fun LevelDto?.toDomainLevel(): io.jadu.statshunter.valorant.valorant_game_infos.contracts.domain.model.Level? {
    return this?.let {
        io.jadu.statshunter.valorant.valorant_game_infos.contracts.domain.model.Level(
            doughCost = it.doughCost,
            isPurchasableWithDough = it.isPurchasableWithDough,
            isPurchasableWithVP = it.isPurchasableWithVP,
            reward = it.reward.toDomainReward()!!,
            vpCost = it.vpCost,
            xp = it.xp
        )
    }
}