package io.jadu.statshunter.valorant.valorant_game_infos.gears.presentation.stateManager

import io.jadu.statshunter.valorant.valorant_game_infos.gears.domain.models.Gears

data class GearsStateManager (
    val gears: Gears? = null,
    val isLoading: Boolean = false,
    val error: String? = null
)