package io.jadu.statshunter.valorant.valorant_game_infos.seasons.data.data_source.remote.dto

import io.jadu.statshunter.valorant.valorant_game_infos.seasons.domain.models.Season

data class SeasonDto(
    val `data`: List<SeasonDataDto>,
    val status: Int
)

fun SeasonDto?.toDomainSeason(): Season {
    return Season(
        data = this?.data?.map { it.toDomainSeasonData() } ?: listOf(),
        status = this?.status ?: 0
    )
}