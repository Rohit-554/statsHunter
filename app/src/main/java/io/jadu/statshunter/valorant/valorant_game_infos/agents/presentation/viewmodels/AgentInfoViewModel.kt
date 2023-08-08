package io.jadu.statshunter.valorant.valorant_game_infos.agents.presentation.viewmodels

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import io.jadu.statshunter.valorant.valorant_game_infos.agents.domain.use_case.GetAgentDetail
import io.jadu.statshunter.valorant.valorant_game_infos.agents.presentation.stateManager.AgentInfoState
import javax.inject.Inject

@HiltViewModel
class AgentInfoViewModel @Inject constructor(
    private val getAgentDetail: GetAgentDetail
) : ViewModel(){




}