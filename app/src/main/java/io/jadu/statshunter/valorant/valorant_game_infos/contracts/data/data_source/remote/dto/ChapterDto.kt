package io.jadu.statshunter.valorant.valorant_game_infos.contracts.data.data_source.remote.dto

import io.jadu.statshunter.valorant.valorant_game_infos.contracts.domain.model.Chapter

data class ChapterDto(
    val freeRewards: List<FreeRewardDto>,
    val isEpilogue: Boolean,
    val levels: List<LevelDto>
)

fun ChapterDto?.toDomainChapter(): Chapter?{
    return this?.let {
        it.freeRewards.map { freeRewardDto -> freeRewardDto.toDomainFreeReward() }.let { it1 ->
            it.levels.map { levelDto -> levelDto.toDomainLevel() }.let { it2 ->
                Chapter(
                    freeRewards = it1,
                    isEpilogue = it.isEpilogue,
                    levels = it2
                )
            }
        }
    }
}
