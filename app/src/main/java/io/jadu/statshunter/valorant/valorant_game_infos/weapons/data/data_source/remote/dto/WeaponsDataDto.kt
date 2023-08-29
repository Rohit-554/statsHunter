package io.jadu.statshunter.valorant.valorant_game_infos.weapons.data.data_source.remote.dto

import io.jadu.statshunter.valorant.valorant_game_infos.weapons.domain.model.AdsStats
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

//TODO: Add toDomainWeaponsData() function