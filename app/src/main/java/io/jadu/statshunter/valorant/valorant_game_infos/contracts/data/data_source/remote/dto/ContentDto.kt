package io.jadu.statshunter.valorant.valorant_game_infos.contracts.data.data_source.remote.dto

import io.jadu.statshunter.valorant.valorant_game_infos.contracts.domain.model.Content

data class ContentDto(
    val chapters: List<ChapterDto>?,
    val premiumRewardScheduleUuid: String?,
    val premiumVPCost: Int?,
    val relationType: String?,
    val relationUuid: String?
)

fun ContentDto?.toDomainContent(): Content {
    return Content(
        chapters = this?.chapters?.map { it.toDomainChapter() } ?: emptyList(),
        premiumRewardScheduleUuid = this?.premiumRewardScheduleUuid ?: "",
        premiumVPCost = this?.premiumVPCost ?: 0,
        relationType = this?.relationType ?: "",
        relationUuid = this?.relationUuid ?: ""
    )
}