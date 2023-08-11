package io.jadu.statshunter.valorant.valorant_game_infos.buddies.data.data_source.remote

import io.jadu.statshunter.valorant.valorant_game_infos.buddies.domain.model.BuddiesInfo

data class BuddiesInfoDto(
    val data: List<DataDto>?,
    val status: Int?
)

fun BuddiesInfoDto?.toDomainBuddiesInfo(): BuddiesInfo {
    return BuddiesInfo(
        data = this?.data?.map { it.toDomainData() } ?: emptyList(),
        status = this?.status ?: 0
    )
}

