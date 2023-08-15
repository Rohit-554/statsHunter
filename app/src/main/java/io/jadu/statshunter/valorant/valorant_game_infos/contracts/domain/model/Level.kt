package io.jadu.statshunter.valorant.valorant_game_infos.contracts.domain.model

data class Level(
    val doughCost: Int,
    val isPurchasableWithDough: Boolean,
    val isPurchasableWithVP: Boolean,
    val reward: Reward,
    val vpCost: Int,
    val xp: Int
)