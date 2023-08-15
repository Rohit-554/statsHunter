package io.jadu.statshunter.valorant.valorant_game_infos.competitiveTiers.data.data_source.remote.dto

import io.jadu.statshunter.valorant.valorant_game_infos.competitiveTiers.domain.model.CompetitiveTiers

data class CompetitiveTiersDto(
    val `data`: List<DataDto>,
    val status: Int
)

fun CompetitiveTiersDto?.toDomainCompetitiveTiers(): CompetitiveTiers {
    return CompetitiveTiers(
        `data` = this?.`data`?.map { it.toDomainTierData() } ?: emptyList(),
        status = this?.status ?: 0
    )
}