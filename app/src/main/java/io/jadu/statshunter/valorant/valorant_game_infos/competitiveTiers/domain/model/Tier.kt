package io.jadu.statshunter.valorant.valorant_game_infos.competitiveTiers.domain.model

data class Tier(
    val backgroundColor: String,
    val color: String,
    val division: String,
    val divisionName: String,
    val largeIcon: String,
    val rankTriangleDownIcon: String,
    val rankTriangleUpIcon: String,
    val smallIcon: String,
    val tier: Int,
    val tierName: String
)
