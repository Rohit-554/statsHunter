package io.jadu.statshunter.valorant.valorant_game_infos.contracts.domain.model

data class Data(
    val assetPath: String,
    val content: Content,
    val displayIcon: String,
    val displayName: String,
    val freeRewardScheduleUuid: String,
    val shipIt: Boolean,
    val uuid: String
)