package io.jadu.statshunter.valorant.valorant_game_infos.seasons.presentation.stateManager

import io.jadu.statshunter.valorant.valorant_game_infos.seasons.domain.models.Season

data class SeasonStateManager (
    val seasonState: Season? = null,
    val isLoading: Boolean = false,
    val error: String? = null
)