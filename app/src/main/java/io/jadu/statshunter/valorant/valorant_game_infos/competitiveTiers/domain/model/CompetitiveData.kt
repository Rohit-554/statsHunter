package io.jadu.statshunter.valorant.valorant_game_infos.competitiveTiers.domain.model

data class CompetitiveData(
    val assetObjectName: String,
    val assetPath: String,
    val tier: List<Tier>,
    val uuid: String
)