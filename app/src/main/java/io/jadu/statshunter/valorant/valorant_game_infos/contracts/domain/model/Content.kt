package io.jadu.statshunter.valorant.valorant_game_infos.contracts.domain.model

data class Content(
    val chapters: List<Chapter?>,
    val premiumRewardScheduleUuid: String,
    val premiumVPCost: Int,
    val relationType: String,
    val relationUuid: String
)