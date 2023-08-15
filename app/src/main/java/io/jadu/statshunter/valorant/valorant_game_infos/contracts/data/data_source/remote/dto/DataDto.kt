package io.jadu.statshunter.valorant.valorant_game_infos.contracts.data.data_source.remote.dto

data class DataDto(
    val assetPath: String,
    val content: ContentDto,
    val displayIcon: String,
    val displayName: String,
    val freeRewardScheduleUuid: String,
    val shipIt: Boolean,
    val uuid: String
)

fun DataDto?.toDomainData(): io.jadu.statshunter.valorant.valorant_game_infos.contracts.domain.model.Data? {
    return this?.let {
        it.content.toDomainContent()?.let { it1 ->
            io.jadu.statshunter.valorant.valorant_game_infos.contracts.domain.model.Data(
                assetPath = it.assetPath,
                content = it1,
                displayIcon = it.displayIcon,
                displayName = it.displayName,
                freeRewardScheduleUuid = it.freeRewardScheduleUuid,
                shipIt = it.shipIt,
                uuid = it.uuid
            )
        }
    }
}