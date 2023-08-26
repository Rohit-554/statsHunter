package io.jadu.statshunter.valorant.valorant_game_infos.weapons.domain.model

data class WeaponsData(
    val assetPath: String,
    val category: String,
    val defaultSkinUuid: String,
    val displayIcon: String,
    val displayName: String,
    val killStreamIcon: String,
    val shopData: ShopData,
    val skins: List<Skin?>,
    val uuid: String,
    val weaponStats: WeaponStats
)