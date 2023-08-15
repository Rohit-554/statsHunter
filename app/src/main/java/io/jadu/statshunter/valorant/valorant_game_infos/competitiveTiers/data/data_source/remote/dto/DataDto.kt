package io.jadu.statshunter.valorant.valorant_game_infos.competitiveTiers.data.data_source.remote.dto

import io.jadu.statshunter.valorant.valorant_game_infos.competitiveTiers.domain.model.CompetitiveData

data class DataDto(
    val assetObjectName: String,
    val assetPath: String,
    val tier: List<TierDto>,
    val uuid: String
)

fun DataDto?.toDomainTierData(): CompetitiveData {
    return CompetitiveData(
        assetObjectName = this?.assetObjectName ?: "",
        assetPath = this?.assetPath ?: "",
        tier = this?.tier?.map { it.toDomainTier() } ?: emptyList(),
        uuid = this?.uuid ?: ""
    )
}
