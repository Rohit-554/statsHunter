package io.jadu.statshunter.valorant.valorant_game_infos.gears.data.data_source.remote.dto

import io.jadu.statshunter.valorant.valorant_game_infos.gears.domain.models.ShopData

data class ShopDataDto(
    val assetPath: String?,
    val canBeTrashed: Boolean?,
    val category: String?,
    val categoryText: String?,
    val cost: Int?,
    val gridPosition: String?,
    val image: String?,
    val newImage: String?,
    val newImage2: String?
)

fun ShopDataDto?.toDomainShopData(): ShopData {
    return ShopData(
        assetPath = this?.assetPath ?: "",
        canBeTrashed = this?.canBeTrashed ?: false,
        category = this?.category ?: "",
        categoryText = this?.categoryText ?: "",
        cost = this?.cost ?: 0,
        gridPosition = this?.gridPosition ?: "",
        image = this?.image ?: "",
        newImage = this?.newImage ?: "",
        newImage2 = this?.newImage2 ?: ""
    )

}

