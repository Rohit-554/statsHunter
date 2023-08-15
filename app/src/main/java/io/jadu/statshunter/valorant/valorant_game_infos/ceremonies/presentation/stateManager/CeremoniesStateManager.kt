package io.jadu.statshunter.valorant.valorant_game_infos.ceremonies.presentation.stateManager

import io.jadu.statshunter.valorant.valorant_game_infos.ceremonies.domain.model.Ceremonies

data class CeremoniesStateManager (
    val ceremoniesInfo: Ceremonies? = null,
    val isLoading: Boolean = false,
    val error: String? = null
)