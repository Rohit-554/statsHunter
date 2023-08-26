package io.jadu.statshunter.valorant.valorant_game_infos.seasons.domain.models

data class Season(
    val `data`: List<SeasonData>,
    val status: Int
)