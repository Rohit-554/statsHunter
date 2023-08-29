package io.jadu.statshunter.valorant.valorant_game_infos.weapons.data.data_source.remote.dto

import io.jadu.statshunter.valorant.valorant_game_infos.weapons.domain.model.Skin

data class SkinDto(
    val assetPath: String?,
    val chromas: List<ChromaDto>?,
    val contentTierUuid: String?,
    val displayIcon: String?,
    val displayName: String?,
    val levels: List<LevelDto>?,
    val themeUuid: String?,
    val uuid: String?,
    val wallpaper: String?,
)

fun SkinDto?.toDomainSkin(): Skin {
    return Skin(
        assetPath = this?.assetPath ?: "",
        chromas = this?.chromas?.map { it.toDomainChroma() } ?: emptyList(),
        contentTierUuid = this?.contentTierUuid ?: "",
        displayIcon = this?.displayIcon ?: "",
        displayName = this?.displayName ?: "",
        levels = this?.levels?.map { it.toDomainLevel() } ?: emptyList(),
        themeUuid = this?.themeUuid ?: "",
        uuid = this?.uuid ?: "",
        wallpaper = this?.wallpaper ?: ""
    )
}