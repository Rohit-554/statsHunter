package io.jadu.statshunter.valorant.valorant_game_infos.gears.domain.models

data class ShopData(
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