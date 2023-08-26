package io.jadu.statshunter.valorant.valorant_game_infos.weapons.data.data_source.remote.dto

import io.jadu.statshunter.valorant.valorant_game_infos.weapons.domain.model.WeaponsData

data class WeaponsDataDto(
    val assetPath: String,
    val category: String,
    val defaultSkinUuid: String,
    val displayIcon: String,
    val displayName: String,
    val killStreamIcon: String,
    val shopData: ShopDataDto,
    val skins: List<SkinDto>,
    val uuid: String,
    val weaponStats: WeaponStatsDto
)

fun WeaponsDataDto?.toDomainWeaponsData():WeaponsData? {
    return this?.let {
        it.shopData.toDomainShopData()?.let { it1 ->
            it.skins.map { skinDto -> skinDto.toDomainSkin() }.let { it2 ->
                it.weaponStats.toDomainWeaponStats()?.let { it3 ->
                    WeaponsData(
                        assetPath = it.assetPath,
                        category = it.category,
                        defaultSkinUuid = it.defaultSkinUuid,
                        displayIcon = it.displayIcon,
                        displayName = it.displayName,
                        killStreamIcon = it.killStreamIcon,
                        shopData = it1,
                        skins = it2,
                        uuid = it.uuid,
                        weaponStats = it3
                    )
                }
            }
        }
    }
}