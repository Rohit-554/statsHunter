package io.jadu.statshunter.valorant.valorant_game_infos.buddies.data.data_source.remote

import io.jadu.statshunter.valorant.valorant_game_infos.buddies.domain.model.Data

data class DataDto(
    val assetPath: String?,
    val displayIcon: String?,
    val displayName: String?,
    val isHiddenIfNotOwned: Boolean?,
    val levelDtos: List<LevelDto>?,
    val themeUuid: String?,
    val uuid: String?
)
fun DataDto?.toDomainData(): Data {
    return Data(
        assetPath = this?.assetPath ?: "",
        displayIcon = this?.displayIcon ?: "",
        displayName = this?.displayName ?: "",
        isHiddenIfNotOwned = this?.isHiddenIfNotOwned ?: false,
        levelDtos = this?.levelDtos?.map { it.toDomainLevel() } ?: emptyList(),
        themeUuid = this?.themeUuid ?: "",
        uuid = this?.uuid ?: ""
    )
}
