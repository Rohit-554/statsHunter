package io.jadu.statshunter.valorant.valorant_game_infos.contracts.domain.model

data class Reward(
    val amount: Int,
    val isHighlighted: Boolean,
    val type: String,
    val uuid: String
)

