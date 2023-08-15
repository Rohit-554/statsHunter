package io.jadu.statshunter.valorant.valorant_game_infos.competitiveTiers.presentation.stateManager

import io.jadu.statshunter.valorant.valorant_game_infos.competitiveTiers.domain.model.CompetitiveTiers

data class CompetitiveTierStateManager(
    val CompetitiveTierInfo: CompetitiveTiers? = null,
    val isLoading: Boolean = false,
    val error: String? = null
)