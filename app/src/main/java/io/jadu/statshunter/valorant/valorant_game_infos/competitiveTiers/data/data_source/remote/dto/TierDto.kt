package io.jadu.statshunter.valorant.valorant_game_infos.competitiveTiers.data.data_source.remote.dto

import io.jadu.statshunter.valorant.valorant_game_infos.competitiveTiers.domain.model.Tier

data class TierDto(
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

fun TierDto?.toDomainTier(): Tier {
    return Tier(
        backgroundColor = this?.backgroundColor ?: "",
        color = this?.color ?: "",
        division = this?.division ?: "",
        divisionName = this?.divisionName ?: "",
        largeIcon = this?.largeIcon ?: "",
        rankTriangleDownIcon = this?.rankTriangleDownIcon ?: "",
        rankTriangleUpIcon = this?.rankTriangleUpIcon ?: "",
        smallIcon = this?.smallIcon ?: "",
        tier = this?.tier ?: 0,
        tierName = this?.tierName ?: ""
    )
}
