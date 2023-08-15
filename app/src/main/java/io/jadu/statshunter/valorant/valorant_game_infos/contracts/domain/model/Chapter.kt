package io.jadu.statshunter.valorant.valorant_game_infos.contracts.domain.model

data class Chapter(
    val freeRewards: List<FreeReward?>,
    val isEpilogue: Boolean,
    val levels: List<Level?>
)

