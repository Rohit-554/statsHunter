package io.jadu.statshunter.valorant.valorant_game_infos.contracts.data.data_source.remote.dto

import io.jadu.statshunter.valorant.valorant_game_infos.contracts.domain.model.Content

data class ContentDto(
    val chapters: List<ChapterDto>,
    val premiumRewardScheduleUuid: String,
    val premiumVPCost: Int,
    val relationType: String,
    val relationUuid: String
)

fun ContentDto?.toDomainContent(): Content?{
    return this?.let {
        it.chapters.map { chapterDto -> chapterDto.toDomainChapter() }.let { it1 ->
            Content(
                chapters = it1,
                premiumRewardScheduleUuid = it.premiumRewardScheduleUuid,
                premiumVPCost = it.premiumVPCost,
                relationType = it.relationType,
                relationUuid = it.relationUuid
            )
        }
    }
}