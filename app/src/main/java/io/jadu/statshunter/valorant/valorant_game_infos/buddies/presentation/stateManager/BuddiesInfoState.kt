package io.jadu.statshunter.valorant.valorant_game_infos.buddies.presentation.stateManager

import io.jadu.statshunter.valorant.valorant_game_infos.agents.domain.model.AgentInfo
import io.jadu.statshunter.valorant.valorant_game_infos.buddies.domain.model.BuddiesInfo

data class BuddiesInfoState(
    val buddiesInfo: BuddiesInfo? = null,
    val isLoading: Boolean = false,
    val error: String? = null
)