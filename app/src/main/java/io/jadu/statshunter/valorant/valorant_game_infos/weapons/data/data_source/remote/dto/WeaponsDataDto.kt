package io.jadu.statshunter.valorant.valorant_game_infos.weapons.data.data_source.remote.dto

import io.jadu.statshunter.valorant.valorant_game_infos.weapons.domain.model.AdsStats
import io.jadu.statshunter.valorant.valorant_game_infos.weapons.domain.model.AirBurstStats
import io.jadu.statshunter.valorant.valorant_game_infos.weapons.domain.model.AltShotgunStats
import io.jadu.statshunter.valorant.valorant_game_infos.weapons.domain.model.DamageRange
import io.jadu.statshunter.valorant.valorant_game_infos.weapons.domain.model.GridPosition
import io.jadu.statshunter.valorant.valorant_game_infos.weapons.domain.model.ShopData
import io.jadu.statshunter.valorant.valorant_game_infos.weapons.domain.model.WeaponStats
import io.jadu.statshunter.valorant.valorant_game_infos.weapons.domain.model.WeaponsData

data class WeaponsDataDto(
    val assetPath: String?,
    val category: String?,
    val defaultSkinUuid: String?,
    val displayIcon: String?,
    val displayName: String?,
    val killStreamIcon: String?,
    val shopData: ShopDataDto?,
    val skins: List<SkinDto>?,
    val uuid: String?,
    val weaponStats: WeaponStatsDto?,
)

fun WeaponsDataDto.toDomainWeaponsData(): WeaponsData {
    return WeaponsData(
        assetPath = this.assetPath ?: "",
        category = this.category ?: "",
        defaultSkinUuid = this.defaultSkinUuid ?: "",
        displayIcon = this.displayIcon ?: "",
        displayName = this.displayName ?: "",
        killStreamIcon = this.killStreamIcon ?: "",
        shopData = this.shopData?.toDomainShopData() ?: ShopData("", false, "", "", 0, GridPosition(0,0), "", "", ""),
        skins = this.skins?.map { it.toDomainSkin() } ?: emptyList(),
        uuid = this.uuid ?: "",
        weaponStats = this.weaponStats?.toDomainWeaponStats() ?: WeaponStats(
            AdsStats(0,0.0,0.0,0.0,0.0),
            AirBurstStats(0.0,0),
            "", AltShotgunStats(0.0,0), emptyList(), 0.0, "", "", 0.0, 0.0, 0,0.0,0.0,0,"")
    )
}