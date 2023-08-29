package io.jadu.statshunter.valorant.valorant_game_infos.maps.presentation.stateManager

import io.jadu.statshunter.valorant.valorant_game_infos.maps.domain.models.Maps

data class MapsStateManager (
    val mapsState: Maps? = null,
    val isLoading: Boolean = false,
    val error: String? = null
)