package io.jadu.statshunter.valorant.valorant_game_infos.gears.data.data_source.remote.dto

import io.jadu.statshunter.valorant.valorant_game_infos.gears.domain.models.GearsData

data class GearsDataDto(
    val assetPath: String?,
    val description: String?,
    val displayIcon: String?,
    val displayName: String?,
    val shopData: ShopDataDto?,
    val uuid: String?
)

fun GearsDataDto?.toDomainGearsData(): GearsData {
    return GearsData(
        assetPath = this?.assetPath ?: "",
        description = this?.description ?: "",
        displayIcon = this?.displayIcon ?: "",
        displayName = this?.displayName ?: "",
        shopData = this?.shopData?.toDomainShopData() ?: ShopDataDto("",false,",","",0,"","","","").toDomainShopData(),
        uuid = this?.uuid ?: ""
    )

}