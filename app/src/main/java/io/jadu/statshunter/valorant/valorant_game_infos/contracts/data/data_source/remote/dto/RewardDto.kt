package io.jadu.statshunter.valorant.valorant_game_infos.contracts.data.data_source.remote.dto

import io.jadu.statshunter.valorant.valorant_game_infos.contracts.domain.model.Reward

data class RewardDto(
    val amount: Int?,
    val isHighlighted: Boolean?,
    val type: String?,
    val uuid: String?
)


fun RewardDto?.toDomainReward(): Reward {
    return Reward(
        amount = this?.amount ?: 0,
        isHighlighted = this?.isHighlighted ?: false,
        type = this?.type ?: "",
        uuid = this?.uuid ?: ""
    )
}

