package io.jadu.statshunter.valorant.valorant_game_infos.weapons.data.data_source.remote.dto

import io.jadu.statshunter.valorant.valorant_game_infos.weapons.domain.model.Skin

data class SkinDto(
    val assetPath: String,
    val chromas: List<ChromaDto>,
    val contentTierUuid: String,
    val displayIcon: String,
    val displayName: String,
    val levels: List<LevelDto>,
    val themeUuid: String,
    val uuid: String,
    val wallpaper: String
)

fun SkinDto?.toDomainSkin(): Skin? {
    return this?.let {
        it.chromas.map { chromaDto -> chromaDto.toDomainChroma() }?.let { it1 ->
            it.levels.map { levelDto -> levelDto.toDomainLevel() }?.let { it2 ->
                Skin(
                    assetPath = it.assetPath,
                    chromas = it1,
                    contentTierUuid = it.contentTierUuid,
                    displayIcon = it.displayIcon,
                    displayName = it.displayName,
                    levels = it2,
                    themeUuid = it.themeUuid,
                    uuid = it.uuid,
                    wallpaper = it.wallpaper
                )
            }
        }
    }
}