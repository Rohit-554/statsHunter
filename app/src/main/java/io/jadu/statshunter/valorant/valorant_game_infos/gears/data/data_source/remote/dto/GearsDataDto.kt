package io.jadu.statshunter.valorant.valorant_game_infos.gears.data.data_source.remote.dto

import io.jadu.statshunter.valorant.valorant_game_infos.gears.domain.models.GearsData

data class GearsDataDto(
    val assetPath: String,
    val description: String,
    val displayIcon: String,
    val displayName: String,
    val shopData: ShopDataDto,
    val uuid: String
)

fun GearsDataDto?.toDomainGearsData(): GearsData? {
    return this?.let {
        it.shopData.toDomainShopData()?.let { it1 ->
            GearsData(
                assetPath = it.assetPath,
                description = it.description,
                displayIcon = it.displayIcon,
                displayName = it.displayName,
                shopData = it1,
                uuid = it.uuid
            )
        }
    }
}