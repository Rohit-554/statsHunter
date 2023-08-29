package io.jadu.statshunter.valorant.valorant_game_infos.contracts.data.data_source.remote.dto

import io.jadu.statshunter.valorant.valorant_game_infos.contracts.domain.model.Content
import io.jadu.statshunter.valorant.valorant_game_infos.contracts.domain.model.Data

data class DataDto(
    val assetPath: String?,
    val content: ContentDto?,
    val displayIcon: String?,
    val displayName: String?,
    val freeRewardScheduleUuid: String?,
    val shipIt: Boolean?,
    val uuid: String?
)

fun DataDto?.toDomainData(): Data {
    return Data(
        assetPath = this?.assetPath ?: "",
        content = this?.content?.toDomainContent() ?: Content(emptyList(), "", 0, "", ""),
        displayIcon = this?.displayIcon ?: "",
        displayName = this?.displayName ?: "",
        freeRewardScheduleUuid = this?.freeRewardScheduleUuid ?: "",
        shipIt = this?.shipIt ?: false,
        uuid = this?.uuid ?: ""
    )
}

