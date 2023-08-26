package io.jadu.statshunter.valorant.valorant_game_infos.gears.data.data_source.remote.dto

import io.jadu.statshunter.valorant.valorant_game_infos.gears.domain.models.ShopData

data class ShopDataDto(
    val assetPath: String,
    val canBeTrashed: Boolean,
    val category: String,
    val categoryText: String,
    val cost: Int,
    val gridPosition: Any,
    val image: Any,
    val newImage: String,
    val newImage2: Any
)

fun ShopDataDto?.toDomainShopData(): ShopData? {
    return this?.let {
        ShopData(
            assetPath = it.assetPath,
            canBeTrashed = it.canBeTrashed,
            category = it.category,
            categoryText = it.categoryText,
            cost = it.cost,
            gridPosition = it.gridPosition,
            image = it.image,
            newImage = it.newImage,
            newImage2 = it.newImage2
        )
    }
}