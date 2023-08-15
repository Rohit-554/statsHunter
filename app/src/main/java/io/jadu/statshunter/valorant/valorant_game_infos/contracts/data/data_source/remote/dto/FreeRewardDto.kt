package io.jadu.statshunter.valorant.valorant_game_infos.contracts.data.data_source.remote.dto

import io.jadu.statshunter.valorant.valorant_game_infos.contracts.domain.model.FreeReward

data class FreeRewardDto(
    val amount: Int,
    val isHighlighted: Boolean,
    val type: String,
    val uuid: String
)

fun FreeRewardDto?.toDomainFreeReward():FreeReward?{
    return this?.let {
        FreeReward(
            amount = it.amount,
            isHighlighted = it.isHighlighted,
            type = it.type,
            uuid = it.uuid
        )
    }
}