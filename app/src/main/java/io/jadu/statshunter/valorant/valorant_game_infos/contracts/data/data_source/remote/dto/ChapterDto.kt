package io.jadu.statshunter.valorant.valorant_game_infos.contracts.data.data_source.remote.dto

import io.jadu.statshunter.valorant.valorant_game_infos.contracts.domain.model.Chapter

data class ChapterDto(
    val freeRewards: List<FreeRewardDto>?,
    val isEpilogue: Boolean?,
    val levels: List<LevelDto>?
)

fun ChapterDto?.toDomainChapter(): Chapter {
    return Chapter(
        freeRewards = this?.freeRewards?.map { it.toDomainFreeReward() } ?: listOf(),
        isEpilogue = this?.isEpilogue ?: false,
        levels = this?.levels?.map { it.toDomainLevel() } ?: listOf()
    )
}
