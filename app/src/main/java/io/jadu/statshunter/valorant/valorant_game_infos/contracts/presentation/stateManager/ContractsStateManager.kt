package io.jadu.statshunter.valorant.valorant_game_infos.contracts.presentation.stateManager

import io.jadu.statshunter.valorant.valorant_game_infos.contracts.domain.model.Contracts

data class ContractsStateManager (
    val contractsInfo: Contracts? = null,
    val isLoading: Boolean = false,
    val error: String? = null
)