package io.jadu.statshunter.valorant.valorant_game_infos.currencies.presentation.stateManager

import io.jadu.statshunter.valorant.valorant_game_infos.currencies.domain.model.Currencies

data class CurrenciesStateManager (
    val currencies: Currencies? = null,
    val isLoading: Boolean = false,
    val error: String? = null
)