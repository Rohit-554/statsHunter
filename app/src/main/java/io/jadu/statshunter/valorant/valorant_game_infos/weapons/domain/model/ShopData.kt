package io.jadu.statshunter.valorant.valorant_game_infos.weapons.domain.model

data class ShopData(
    val assetPath: String,
    val canBeTrashed: Boolean,
    val category: String,
    val categoryText: String,
    val cost: Int,
    val gridPosition: GridPosition,
    val image: Any,
    val newImage: String,
    val newImage2: Any
)