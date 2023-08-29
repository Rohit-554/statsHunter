package io.jadu.statshunter.valorant.valorant_game_infos.game_modes.presentation.stateManager

import io.jadu.statshunter.valorant.valorant_game_infos.game_modes.domain.model.GameModes

data class GameModeStateManager(
    val gameModeState: GameModes? = null,
    val isLoading: Boolean = false,
    val error: String? = null
)