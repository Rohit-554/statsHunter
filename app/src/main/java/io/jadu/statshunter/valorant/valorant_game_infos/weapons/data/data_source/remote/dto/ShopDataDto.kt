package io.jadu.statshunter.valorant.valorant_game_infos.weapons.data.data_source.remote.dto

import io.jadu.statshunter.valorant.valorant_game_infos.weapons.domain.model.GridPosition
import io.jadu.statshunter.valorant.valorant_game_infos.weapons.domain.model.ShopData

data class ShopDataDto(
    val assetPath: String?,
    val canBeTrashed: Boolean?,
    val category: String?,
    val categoryText: String?,
    val cost: Int?,
    val gridPosition: GridPositionDto?,
    val image: Any?,
    val newImage: String?,
    val newImage2: Any?,
)

fun ShopDataDto?.toDomainShopData(): ShopData {
    return ShopData(
        assetPath = this?.assetPath ?: "",
        canBeTrashed = this?.canBeTrashed ?: false,
        category = this?.category ?: "",
        categoryText = this?.categoryText ?: "",
        cost = this?.cost ?: 0,
        gridPosition = this?.gridPosition?.toDomainGridPosition() ?: GridPosition(0,0),
        image = this?.image ?: "",
        newImage = this?.newImage ?: "",
        newImage2 = this?.newImage2 ?: ""
    )
}